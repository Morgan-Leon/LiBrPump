package lyn.librpump.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.beardedhen.androidbootstrap.BootstrapButton;

import lyn.callibrpump.R;
import lyn.librpump.kernel.pump.Pump;
import lyn.librpump.model.LiBrPumpDBHelper;




/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalCOPFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalCOPFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalCOPFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    LiBrPumpDBHelper dbHelper;
    EditText t_wai, t_wco, t_wei, t_weo;
    BootstrapButton clearInputButton, createPumpButton;

    private OnFragmentInteractionListener mListener;

    public CalCOPFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalCOPFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalCOPFragment newInstance(String param1, String param2) {
        CalCOPFragment fragment = new CalCOPFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cal_cop, container, false);

        t_wai = (EditText) view.findViewById(R.id.t_wai);


        t_wco = (EditText) view.findViewById(R.id.t_wco);


        t_wei = (EditText) view.findViewById(R.id.t_wei);


        t_weo = (EditText) view.findViewById(R.id.t_weo);

        clearInputButton = (BootstrapButton) view.findViewById(R.id.clearInput);

        createPumpButton = (BootstrapButton) view.findViewById(R.id.createPump);

        View.OnClickListener clearInputListener = new View.OnClickListener() {
            public void onClick(View v) {
                t_wai.setText("");
                t_wco.setText("");
                t_wei.setText("");
                t_weo.setText("");
            }
        };

        clearInputButton.setOnClickListener(clearInputListener);

        View.OnClickListener createPumpListener = new View.OnClickListener() {
            public void onClick(View v) {
                //读取数据
                double Twai = Double.valueOf(t_wai.getText().toString());

                double Twco = Double.valueOf(t_wco.getText().toString());

                double Twei = Double.valueOf(t_wei.getText().toString());

                double Tweo = Double.valueOf(t_weo.getText().toString());

                Pump pump = new Pump(Twai,Twco,Twei,Tweo);

                Snackbar.make(v, "COP = " + pump.getCOP(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        };

        createPumpButton.setOnClickListener(createPumpListener);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}


