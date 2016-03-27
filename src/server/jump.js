import express from 'express';
import request from 'request';

let router = express.Router();


router.post('/jump', function(req, res, next) {
  // console.log(req.body);
  request({
    timeout:1,
    har: {
      url: req.body.url,
      method: req.body.method,
      headers: req.body.headers,
      postData: {
        mimeType: 'application/json',
        params: req.body.payload
      }
    }
  }, function(error, response, body) {
    if (!error && response.statusCode === 200) {
      console.log(body); // Show the HTML for the Google homepage.
      res.send(body);
    } else {
      res.status(500);
    }
  });
 

  // res.status(200);
  // res.end();


});


export default router;