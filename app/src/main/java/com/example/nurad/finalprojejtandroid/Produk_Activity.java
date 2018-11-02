package com.example.nurad.finalprojejtandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Produk_Activity extends AppCompatActivity {
    private TextView tvtitle,tvdescription,tvcategory, tvharga, pricetextview, thanksorder ;
    private ImageView img;
    int quantity=0;
    int harga, gambar;
    int total;
    String totalHarga, judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_);
        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        tvcategory = (TextView) findViewById(R.id.txtCat);
        tvharga = (TextView) findViewById(R.id.txtHarga);
        img = (ImageView) findViewById(R.id.Produkthumbnail);


        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Category = intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Description");
        int Harga = intent.getExtras().getInt("Harga");
        int image = intent.getExtras().getInt("Thumbnail") ;


        //ubah value
        //Locale localeID = new Locale("in", "ID");
        //NumberFormat formatRp = NumberFormat.getCurrencyInstance(localeID);
        // Double hrg = Double.valueOf(Harga);
        // Setting values
        tvtitle.setText(Title);
        tvcategory.setText(Category);
        tvdescription.setText(Description);
        tvharga.setText(String.valueOf(Harga));
        img.setImageResource(image);
    }

    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
           display(quantity);
    }
    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
          display(quantity);
    }


    public void konvert(){
        pricetextview = (TextView) findViewById(R.id.price_textview);
        thanksorder = (TextView) findViewById( R.id.Thanks_Order);

        Intent intent = getIntent();
        harga = intent.getExtras().getInt("Harga");
        judul = intent.getExtras().getString("Title");
        gambar = intent.getExtras().getInt("Thumbnail") ;
        total = harga*quantity;

    }

    @SuppressLint("SetTextI18n")
    public void Submitorder(View view) {
        konvert();
        totalHarga = Integer.toString(total);
        pricetextview.setText("Rp. " +totalHarga);
        thanksorder.setText("Terimakasih Telah, Memesan Makanan di Tempat Kami" +
                "\nUntuk Pembayarannya silahkan Langsung Datang Ke Outlet kami");
        Toast.makeText( this, "Terimakasih Telah Melakukan Order", Toast.LENGTH_SHORT ).show();


        // passing data to the book activity
        Intent intent = null;
        intent.putExtra("Title",judul);
        intent.putExtra("Harga",harga);
        intent.putExtra("Thumbnail",gambar);
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
}
