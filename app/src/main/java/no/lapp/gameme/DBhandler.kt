package no.lapp.gameme

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import android.widget.Toast


val DATABASE_NAME= "UserDB"
val TABLE_NAME="Users"
val COL_NAME="Name"
val COL_NICKNAME="NickName"
val COL_EMAIL="Email"
val COL_PASSWORD="Password"
val COL_DATEOFBIRTH ="Date of Birth"
val COL_ID="id"


class DBhandler (var context: Context) : SQLiteOpenHelper(context , DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CRATE TABLE" + TABLE_NAME +" ("+
                COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT" +
                COL_NAME + "VARCHAR(256)," +
                COL_NICKNAME + "VARCHAR(256)," +
                COL_EMAIL + "VARCHAR(256)," +
                COL_PASSWORD + "VARCHAR(256)," +
                COL_DATEOFBIRTH + "VARCHAR(256)),"

            db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }



    fun insertdata (user:User){

          val db = this.writableDatabase
          var cv = ContentValues()

          cv.put(COL_NAME,user.name)
          cv.put(COL_NICKNAME,user.nickname)
          cv.put(COL_EMAIL,user.email)
          cv.put(COL_PASSWORD,user.password)
         // cv.put(COL_DATEOFBIRTH,user.dateOfBirth)

          val result = db.insert(TABLE_NAME,null,cv)
          if (result == -1.toLong() ){

              Toast.makeText(context,"failed",Toast.LENGTH_SHORT).show()

          }else{
              Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
          }






      }
    }


}