const express = require('express');
const mysql = require('mysql');
const  ejs = require('ejs');


const port = 3000

// ======== Connected NodeJS via MySQL========
var cnx = mysql.createConnection({
host : "localhost",
user : "root",
password :"",
database : "gestion_formations"
})
const app = express();
app.set('view engine', 'ejs');


cnx.connect(function(error){
    if(!!error) console.log(error);
    else  console.log('Connected successfuly! :)')
});


app.get('/Session/:idSession', (req, res) => {
    let idSession = req.params.idSession;

    const sql = `SELECT * FROM session where idSession = ${idSession}`;
    cnx.query(sql, (err, row) => {
        console.log(row)
           if (err) throw err;
           res.render('home', {
            
               row: row
           });
   
       })
   
   });


   app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
  })