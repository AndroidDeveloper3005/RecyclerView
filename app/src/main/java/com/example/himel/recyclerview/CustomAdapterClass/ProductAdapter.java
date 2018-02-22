package com.example.himel.recyclerview.CustomAdapterClass;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.himel.recyclerview.ModelClass.Item;
import com.example.himel.recyclerview.ModelClass.Product;
import com.example.himel.recyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HIMEL on 2/19/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private ArrayList<Product>products;

    public ProductAdapter(Context context, ArrayList<Product>productArrayList){
        this.context =context;
        this.products=productArrayList;


    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      LayoutInflater inflater = LayoutInflater.from(parent.getContext());
      View view= inflater.from(parent.getContext()).inflate(R.layout.product_cardview_layout, parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

       Product product = products.get(position);
       holder.nameProduct.setText(product.name);
        holder.priceProduct.setText(""+product.price);
        //http://192.168.0.103/customer/
        String fulUrl = "http://192.168.0.103/customer/" + product.getImage_url();
        Picasso.with(context)
                .load(fulUrl)
                .placeholder(R.drawable.d)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.productImage);

    }

    @Override
    public int getItemCount() {


        if (products !=null) {
            return products.size();
        }
        return 0;
    }


    //viewholder class
    public static  class ProductViewHolder extends RecyclerView.ViewHolder{
        public CardView cardViewProduct;
        public ImageView productImage;
        public TextView nameProduct;
        public TextView priceProduct;


      public ProductViewHolder(View itemView) {
          super(itemView);
          cardViewProduct = itemView.findViewById(R.id.cvProduct);
          productImage = itemView.findViewById(R.id.ivImgProduct);
          nameProduct = itemView.findViewById(R.id.tvproductName);
          priceProduct = itemView.findViewById(R.id.tvproductPrice);
      }
  }


}
