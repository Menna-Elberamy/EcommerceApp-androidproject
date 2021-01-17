package com.example.finalproject_diploma.fragments;

import android.app.ProgressDialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_diploma.ProductModel;
import com.example.finalproject_diploma.adapter.ProductRvAdapter;
import com.example.finalproject_diploma.R;
import com.example.finalproject_diploma.webServices.ProductsResponse;
import com.example.finalproject_diploma.webServices.RetrofitFactory;
import com.example.finalproject_diploma.webServices.webServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    RecyclerView productRv;
    private ProductRvAdapter adapter;
    private List<ProductModel> productModelList = new ArrayList<>();
    private webServices webServices;
    private ProgressDialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        productRv=view.findViewById(R.id.home_rv);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SetUpProgressDialog();

        dialog.show();
        setUpRecyclerView();
        CallProductsAPI();
    }

    private void SetUpProgressDialog() {
        dialog = new ProgressDialog(requireContext());
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

    }

    private void CallProductsAPI() {
        webServices = RetrofitFactory.getRetrofit().create(webServices.class);
        Call<ProductsResponse> getProducts = webServices.getproducts();
        getProducts.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                dialog.dismiss();
                productModelList.clear();
                productModelList.addAll(response.body().getProductlList());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(requireContext(), "Error Happened", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(requireContext() , 2);
        productRv.setLayoutManager(layoutManager);

        productRv.addItemDecoration(new GridSpacingItemDecoration(2, 50, true));
        productRv.setItemAnimator(new DefaultItemAnimator());



//        ProductModel productModel = new ProductModel("man white t-shirt","man white regular fit polol" , "200 EGP");
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);
//        productModelList.add(productModel);




        adapter = new ProductRvAdapter(productModelList, requireContext(), new ProductRvAdapter.OnProductClickListener() {
            @Override
            public void onProductListener(View view, int position) {
                ProductModel selectedModel = productModelList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("currentproduct" , selectedModel);
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_productDetailsFragment,bundle);
            }
        });
        productRv.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

}