import express from 'express';
import compression from 'compression';
import path from 'path';
import http from 'http';
import datasets from './datasets';
import hkevents from './hkevents';
import config from 'config';
import dataAccessAdapter from './util/dataAccessAdapter';
import bodyParser from 'body-parser';

let app = express();

app.use(compression());
app.use(bodyParser.json());

dataAccessAdapter.InitDB();
let server = http.createServer(app);

app.use('/datasets', datasets);
app.use('/hk', hkevents);

// In development mode, we create a proxy server to forward all
// http request to the webpack-dev-server
if (config.watch) {
  let httpProxy = require('http-proxy');
  let proxy = httpProxy.createProxyServer();

  app.all('*', function(req, res) {
    proxy.web(req, res, {
      target: 'http://localhost:' + config.ports.devServer
    });
  });

  proxy.on('error', function(e) {
    console.log('Could not connect to proxy, please try again...');
  });

} else {
  app.use(express.static(path.join(__dirname, '../../build/website')));
}

export default server;
