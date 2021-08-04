package com.bihanmahadewa.dominospizza;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import org.w3c.dom.Text;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Context context;

    public ProductAdapter(Context context, List<Product> products){
        super(context, R.layout.product_item, products);

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.product_item, null);

        TextView txtTitle = v.findViewById(R.id.txt_title);
        TextView txtDescription = v.findViewById(R.id.txt_description);
        TextView txtPrice = v.findViewById(R.id.txt_price);
        RelativeLayout layoutBg = v.findViewById(R.id.layout_background);

        Product product = getItem(position);

        txtTitle.setText(product.getProductTitle());
        txtDescription.setText(product.getProductDescription());
        txtPrice.setText("Rs. " + product.getProductPrice());
        Glide.with(context).load(product.getProductImg()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                layoutBg.setBackground(resource);
            }
        });

        String[] sizeData = new String[]{"Regular", "Medium", "Large"};
        String[] crustData = new String[]{"Classic Hand Tossed", "Wheat Thin Crust", "Cheese Burst", "Cheese Float"};

        Spinner spinnerSizes = v.findViewById(R.id.spinner_size);
        Spinner spinnerCrusts = v.findViewById(R.id.spinner_crus);

        ArrayAdapter<String> sizesAdapter = new ArrayAdapter<>(context, R.layout.spinner_item, sizeData);
        ArrayAdapter<String> crustAdapter = new ArrayAdapter<>(context, R.layout.spinner_item, crustData);

        spinnerSizes.setAdapter(sizesAdapter);
        spinnerCrusts.setAdapter(crustAdapter);

        return v;
    }
}
