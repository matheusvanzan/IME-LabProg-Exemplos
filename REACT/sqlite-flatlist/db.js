import * as SQLite from 'expo-sqlite';

DB_NAME = 'db_teste_2';

export async function create() {

  try {
    const db = await SQLite.openDatabaseAsync(DB_NAME);
    console.log(db);

    result = await db.runAsync(`
      CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY NOT NULL, first_name TEXT, last_name TEXT, email TEXT, uri TEXT);
    `);

  } catch (error) {
      console.log(error);
  }  
}

export async function insert(first_name, last_name, email, uri) {
  try {
    const db = await SQLite.openDatabaseAsync(DB_NAME);
    console.log(db);

    let result = await db.runAsync(`INSERT INTO users (first_name, last_name, email, uri) VALUES (?, ?, ?, ?);`, first_name, last_name, email, uri);
    console.log('insert result', result);

  } catch (error) {
      console.log(error);
  }  
}

export async function listAll() {
  try {
    const db = await SQLite.openDatabaseAsync(DB_NAME);
    console.log(db);

    let result = await db.getAllAsync(`SELECT * FROM users`);
    console.log('listAll result', result);

    return result;
    
  } catch (error) {
      console.log(error);
  }  
}