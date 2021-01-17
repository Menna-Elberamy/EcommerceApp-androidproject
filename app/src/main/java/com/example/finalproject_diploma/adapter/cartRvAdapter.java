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

public class cartRvAdapter extends RecyclerView.Adapter<cartRvAdapter.cartViewHolder> {
    private List<ProductModel> productList;
    private Context context;

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_rv ,parent, false);
        return new cartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
        ProductModel ProductModel =productList.get(position);
        holder.cartTitleTv.setText(ProductModel.getProductTitle());
        holder.cartDescTv.setText(ProductModel.getProductDescp());
        holder.cartPriceTv.setText(ProductModel.getGetProductPrice());
        Glide.with(context).load(ProductModel.getProductImage()).into(holder.cartImgIv);


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class cartViewHolder extends RecyclerView.ViewHolder{
        TextView cartTitleTv;
        TextView cartDescTv;
        TextView cartPriceTv;
        TextView cartQuanTv;
        ImageView cartImgIv;
        ImageButton cartIncImgBtn;
        ImageButton cartDecImgBtn;

        public cartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartTitleTv=itemView.findViewById(R.id.cart_title_tv);
            cartDescTv=itemView.findViewById(R.id.cart_desc_tv);
            cartPriceTv=itemView.findViewById(R.id.cart_price_tv);
            cartQuanTv=itemView.findViewById(R.id.cart_quantity_tv);
            cartImgIv=itemView.findViewById(R.id.cartimage_iv);
            cartIncImgBtn=itemView.findViewById(R.id.cart_incproducr_imgbtn);
            cartDecImgBtn=itemView.findViewById(R.id.cart_decproducr_imgbtn);

        }
    }
}
