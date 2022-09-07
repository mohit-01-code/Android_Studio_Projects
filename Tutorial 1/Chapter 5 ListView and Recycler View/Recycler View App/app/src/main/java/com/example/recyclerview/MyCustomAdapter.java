package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> {
    //    String[] arr2 = {"Heyy there! Are you using WhatsApp", "What are you doing tomorrow?", "How's your scholarship going on?", "When are the elections", "Yo whatsapp", "Nice status", "hii...", "ok", "Happy birthday", "Good Morning", "Send time table", "ok..i'll do it", "Thank you", "Call me urgent", "I'll call you later"};
//    String[] arr3 = {"08:18", "12:15", "11:54", "09:17", "00:08", "Yesterday", "Yesterday", "06/04/2022", "06/04/2022", "05/04/2022", "05/04/2022", "04/04/2022", "01/04/2022", "31/03/2022", "31/03/2022"};
    private MyData localDataSet;

    //    Step 1:  Initialize the dataset of the Adapter.
    public MyCustomAdapter(MyData dataSet) {
        localDataSet = dataSet;
    }

    //Step 2: Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_custom_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    //Step 3: Replace the contents of a view (invoked by the layout manager)
//    setting all data
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet.arr1[position]);
        viewHolder.textView5.setText(localDataSet.arr2[position]);
        viewHolder.textView7.setText(localDataSet.arr3[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.arr1.length;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textView5;
        private final TextView textView7;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
            textView5 = (TextView) view.findViewById(R.id.textView5);
            textView7 = (TextView) view.findViewById(R.id.textView7);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getTextView().getContext(), "Thanks for using WhatsApp", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
