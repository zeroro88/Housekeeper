import sqlite3 from 'sqlite3';

var DataBase = function() {};
DataBase.GetDB =
  function() {
    if (typeof DataBase.db === 'undefined') {
      DataBase.InitDB();
    }
    return DataBase.db;
  };

DataBase.InitDB = function() {
  DataBase.db = new sqlite3.Database(':memory:');
  DataBase.db.serialize(function() {
    DataBase.db.run("CREATE TABLE lorem (info TEXT)");

    var stmt = DataBase.db.prepare("INSERT INTO lorem VALUES (?)");
    for (var i = 0; i < 10; i++) {
      stmt.run("Ipsum " + i);
    }
    stmt.finalize();

    DataBase.db.each("SELECT rowid AS id, info FROM lorem", function(err, row) {
      console.log(row.id + ": " + row.info);
    });
  });
  DataBase.db.close();
};

DataBase.Disconnect = function() {
  if (DataBase.db) {
    DataBase.db.close();
  }
};
export default DataBase;
