package datnguyen.lab.passioproject.adapter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import datnguyen.lab.passioproject.R;
import datnguyen.lab.passioproject.model.Drink;

public class RecyclerOrderAdapter extends RecyclerView.Adapter<RecyclerOrderAdapter.MyViewHolder> {
    Context context;
    List<Drink> drinkList;
    Dialog dialog_add_to_cart;
    int quantity_pr = 1;
    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public RecyclerOrderAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.drink_item, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(v);


        dialog_add_to_cart = new Dialog(context);
        dialog_add_to_cart.setContentView(R.layout.dialog_add_to_cart_2);
        dialog_add_to_cart.getWindow()
                .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );


        myViewHolder.item_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView tv_drink_name_107, tv_price_107, tv_quantity, tv_total_107;
                RelativeLayout rlt_add_to_cart;
                RadioButton rdbM, rdbL;
                rdbM = dialog_add_to_cart.findViewById(R.id.rdb_m_107);
                rdbL = dialog_add_to_cart.findViewById(R.id.rdb_l_107);
                rdbM.setChecked(true);
                rlt_add_to_cart = dialog_add_to_cart.findViewById(R.id.layout_add_to_cart_107);
                ImageView img_drink_107, img_close_diag, minus, plus;

                tv_drink_name_107 = dialog_add_to_cart.findViewById(R.id.tv_drink_name_107);
                tv_price_107 = dialog_add_to_cart.findViewById(R.id.tv_drink_price_107);
                tv_total_107 = dialog_add_to_cart.findViewById(R.id.tv_total_price_107);
                img_drink_107 = dialog_add_to_cart.findViewById(R.id.img_drink_107);
                img_close_diag = dialog_add_to_cart.findViewById(R.id.img_close_dialog_107);
                minus = dialog_add_to_cart.findViewById(R.id.img_descrease_107);
                plus = dialog_add_to_cart.findViewById(R.id.img_plus_107);
                tv_quantity = dialog_add_to_cart.findViewById(R.id.tv_count_107);

                tv_quantity.setText("1");
                rlt_add_to_cart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                minus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Long.parseLong(String.valueOf(tv_quantity.getText())) > 1)
                            quantity_pr--;
                        tv_quantity.setText(quantity_pr);

                        Long total = quantity_pr * Long.parseLong(String.valueOf(tv_price_107.getText()));
                        tv_total_107.setText(decimalFormat.format(total) + "đ");
                    }
                });
                plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        quantity_pr++;
                        tv_quantity.setText(String.valueOf(quantity_pr));
                        Long total = Long.parseLong((String) tv_quantity.getText()) * Long.parseLong(String.valueOf(drinkList.get(myViewHolder.getAdapterPosition()).getPrice()));
                        tv_total_107.setText(String.valueOf(total)+"đ");
                    }
                });

                img_close_diag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog_add_to_cart.dismiss();
                    }
                });
                rdbL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Long money = drinkList.get(myViewHolder.getAdapterPosition()).getPrice() + 10000;
                        tv_price_107.setText(String.valueOf(money)+ "đ");
                    }
                });
                rdbM.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_price_107.setText(drinkList.get(myViewHolder.getAdapterPosition()).getPrice() + "đ");
                    }
                });

                tv_drink_name_107.setText(drinkList.get(myViewHolder.getAdapterPosition()).getDrinkName());
                tv_price_107.setText(drinkList.get(myViewHolder.getAdapterPosition()).getPrice() + "đ");
                img_drink_107.setImageResource(drinkList.get(myViewHolder.getAdapterPosition()).getUrlImage());
                dialog_add_to_cart.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

                dialog_add_to_cart.show();

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name_drink.setText(drinkList.get(position).getDrinkName());
        holder.tv_price.setText(decimalFormat.format(drinkList.get(position).getPrice())+"đ");
        holder.img_drink.setImageResource(drinkList.get(position).getUrlImage());
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout item_drink;
        ImageView img_drink;
        TextView tv_name_drink, tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_drink = (RelativeLayout) itemView.findViewById(R.id.layout_item_drink_107);
            img_drink = itemView.findViewById(R.id.img_drink_107);
            tv_name_drink = itemView.findViewById(R.id.tv_drink_name_107);
            tv_price = itemView.findViewById(R.id.tv_drink_price_107);

        }
    }
}
