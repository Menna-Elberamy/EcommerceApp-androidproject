package com.example.finalproject_diploma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject_diploma.ProductModel;
import com.example.finalproject_diploma.R;

import java.util.List;

public class ProductRvAdapter extends RecyclerView.Adapter<ProductRvAdapter.productViewHolder> {

    private List<ProductModel> productList;
    private Context context;
    private OnProductClickListener onproductClickListener;

    public interface OnProductClickListener {
        void onProductListener(View view , int position);
    }


    public ProductRvAdapter(List<ProductModel> productList, Context context , OnProductClickListener onproductClickListener) {
        this.productList = productList;
        this.onproductClickListener = onproductClickListener;
        this.context=context;
    }

    //    public ProductRvAdapter(List<ProductModel> productList, OnProductClickListener onproductClickListener) {
//        this.productList = productList;
//        this.onproductClickListener = onproductClickListener;
//    }

//    public ProductRvAdapter(List<ProductModel> productList, Context context) {
//        this.productList = productList;
//    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_rv_item ,parent , false);
        return new productViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHolder holder, int position) {
        ProductModel productModel = productList.get(position);
        holder.titleTv.setText(productModel.getProductTitle());
        holder.detailTv.setText(productModel.getProductDescp());
        holder.priceTv.setText(productModel.getGetProductPrice());

       Glide.with(context).load(productModel.getProductImage()).into(holder.productIv);




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onproductClickListener.onProductListener(v,holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class productViewHolder extends RecyclerView.ViewHolder{
        TextView titleTv;
        TextView detailTv;
        TextView priceTv;
        ImageView productIv;
        ImageButton addIb;

        public productViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv=itemView.findViewById(R.id.title_tv);
            detailTv=itemView.findViewById(R.id.detail_tv);
            priceTv=itemView.findViewById(R.id.price_tv);
            productIv=itemView.findViewById(R.id.product_iv);
            addIb=itemView.findViewById(R.id.add_ib);
        }
    }
}
