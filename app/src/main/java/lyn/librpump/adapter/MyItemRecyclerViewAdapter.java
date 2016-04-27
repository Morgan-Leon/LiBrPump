package lyn.librpump.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lyn.callibrpump.R;
import lyn.librpump.fragment.ItemFragment.OnListFragmentInteractionListener;
import lyn.librpump.fragment.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mTitleView.setText(mValues.get(position).title);
        holder.mTwaiView.setText("Twai=" + mValues.get(position).iTwai + "℃");
        holder.mTwcoView.setText("Twco=" + mValues.get(position).iTwco + "℃");
        holder.mTweiView.setText("Twei=" +mValues.get(position).iTwei + "℃");
        holder.mTweoView.setText("Tweo=" +mValues.get(position).iTweo + "℃");


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mTitleView;
        public final TextView mTwaiView;
        public final TextView mTwcoView;
        public final TextView mTweiView;
        public final TextView mTweoView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mTitleView = (TextView) view.findViewById(R.id.title);
            mTwaiView = (TextView) view.findViewById(R.id.iTwai);
            mTwcoView = (TextView) view.findViewById(R.id.iTwco);
            mTweiView = (TextView) view.findViewById(R.id.iTwei);
            mTweoView = (TextView) view.findViewById(R.id.iTweo);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
