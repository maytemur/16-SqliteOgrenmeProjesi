package com.maytemur.sqliteogrenmeprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //try catch

        try {
            val veritabani = this.openOrCreateDatabase("Urunler", MODE_PRIVATE,null)
            //veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY, isim VARCHAR, fiyat INT)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Ayakkabi',125)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Elbise',150)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Tshirt',50)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Atki',75)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Bere',65)")


            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE '%e'",null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE 'A%'",null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE id=3",null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim='Bere'",null)
            val cursor = veritabani.rawQuery("SELECT * FROM urunler",null)

            //veritabani.execSQL("DELETE FROM urunler WHERE id=5")
            //veritabani.execSQL("UPDATE urunler SET fiyat =250 WHERE ='Atki'")
            //veritabani.execSQL("UPDATE urunler SET isim ='Ayakkab' WHERE id=1")

            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")

            while (cursor.moveToNext()){
                println("ID : ${cursor.getInt(idColumnIndex)}")
                println("Isim: ${cursor.getString(isimColumnIndex)}")
                println("Fiyat: ${cursor.getInt(fiyatColumnIndex)}")

            }
            cursor.close()



        } catch (e: Exception ){
            e.printStackTrace()
        }

    }
}