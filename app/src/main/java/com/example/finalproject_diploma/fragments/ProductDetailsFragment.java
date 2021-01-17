package com.example.finalproject_diploma.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.finalproject_diploma.ProductModel;
import com.example.finalproject_diploma.R;


public class ProductDetailsFragment extends Fragment {
    private ImageView productDetailsIv;
    private TextView descTitleDetailTv;
    private TextView fullDescTitleDetailTv;
    private TextView priceDetailTv;
    private TextView descDetailTv;
    private Button addToCartBtn;
    ProductModel productModel = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_product_details, container, false);
        productDetailsIv=view.findViewById(R.id.product_details_iv);
        priceDetailTv=view.findViewById(R.id.price_detail_tv);
        descTitleDetailTv=view.findViewById(R.id.desctitle_detail_tv);
        fullDescTitleDetailTv=view.findViewById(R.id.fulldesctitle_detail_tv);
        descDetailTv=view.findViewById(R.id.desc_detail_tv);
        addToCartBtn=view.findViewById(R.id.addtocart_btn);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getProductObjectFromHomeFragments();
    }

    private void getProductObjectFromHomeFragments() {
        Bundle args = getArguments();
        if(args!=null) {
            productModel=(ProductModel)args.getSerializable("currentproduct");
            descTitleDetailTv.setText(productModel.getProductTitle());
            fullDescTitleDetailTv.setText(productModel.getProductDescp());
            priceDetailTv.setText(productModel.getGetProductPrice());
            Glide.with(requireContext()).load(productModel.getProductImage()).into(productDetailsIv);



        }

    }
}