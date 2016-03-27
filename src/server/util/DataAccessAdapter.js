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
  DataBase.db = new sqlite3.cached.Database(':memory:');
  DataBase.db.serialize(function() {
    DataBase.db.run("CREATE TABLE hkevents (name TEXT, type TEXT, logdata TEXT)");
  });
};


DataBase.Disconnect = function() {
  if (DataBase.db) {
    DataBase.db.close();
  }
};
export default DataBase;
