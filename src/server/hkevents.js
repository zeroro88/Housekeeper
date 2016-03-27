import express from 'express';
import cars from './cars.json';
import dataAccessAdapter from './util/dataAccessAdapter';

let router = express.Router();

router.get('/events', function(req, res, next) {
  let db = dataAccessAdapter.GetDB();

  let result = [];
  db.all("SELECT rowid AS id, name, type, logdata FROM hkevents", function(err, rows) {
    let result = [];
    _.each(rows, function(row, key, list) {
      result.push({
        "id": row.id,
        "name": row.name,
        "type": row.type,
        "logdata": row.logdata
      });
    });
    res.json(result);
  });
});

router.post('/events', function(req, res, next) {
  dataAccessAdapter.GetDB().run("INSERT INTO hkevents VALUES (?,?,?)", [req.body.name, req.body.type, req.body.logdata], function(err, row) {
    if (err) {
      console.err(err);
      res.status(500);
    } else {
      res.status(202);
    }
    res.end();
  });

});


export default router;