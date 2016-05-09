package lyn.librpump.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gc.materialdesign.views.ButtonRectangle;
import com.rengwuxian.materialedittext.MaterialEditText;

import lyn.callibrpump.R;
import static lyn.librpump.kernel.formular.Formular.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalH2OFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalH2OFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalH2OFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private MaterialEditText editTextLgsvp;
    private ButtonRectangle  buttonRectangleLgsvp;

    private MaterialEditText editTextST;
    private ButtonRectangle  buttonRectangleST;

    private MaterialEditText editTextEnthalpy;
    private ButtonRectangle  buttonRectangleEnthalpy;

    private MaterialEditText editTextVaporEnthalpy;
    private ButtonRectangle  buttonRectangleVaporEnthalpy;



    public CalH2OFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalH2OFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalH2OFragment newInstance(String param1, String param2) {
        CalH2OFragment fragment = new CalH2OFragment();
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
        View view = inflater.inflate(R.layout.fragment_cal_h2o, container, false);

        //计算饱和水蒸气压
        editTextLgsvp = (MaterialEditText)view.findViewById(R.id.textfield_lgsvp);
        editTextLgsvp.setHelperText("");

        buttonRectangleLgsvp = (ButtonRectangle) view.findViewById(R.id.button_lgsvp);

        View.OnClickListener calLgsvp = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double saturationTemperatureH2O_C = Double.valueOf(editTextLgsvp.getText().toString());
                double mmHg = lgsvp(conversionT_C2K(saturationTemperatureH2O_C));
                double result = conversion_P_lgmmHg2kPa(mmHg);
                editTextLgsvp.setHelperText("结果: " + result + "kPa");
            }
        };
        buttonRectangleLgsvp.setOnClickListener(calLgsvp);

        //计算饱和水蒸气温度
        editTextST = (MaterialEditText)view.findViewById(R.id.textfield_st);
        editTextST.setHelperText("");

        buttonRectangleST = (ButtonRectangle) view.findViewById(R.id.button_st);

        View.OnClickListener calST = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double satsaturationPressureH2O_kPa = Double.valueOf(editTextST.getText().toString());
                double result = saturationTemperatureH2O(satsaturationPressureH2O_kPa);
                editTextST.setHelperText("结果: " + result + "℃");
            }
        };
        buttonRectangleST.setOnClickListener(calST);

        //计算水的焓值
        editTextEnthalpy = (MaterialEditText)view.findViewById(R.id.textfield_enthalpy);
        editTextEnthalpy.setHelperText("");

        buttonRectangleEnthalpy = (ButtonRectangle) view.findViewById(R.id.button_enthalpy);

        View.OnClickListener calEnthalpy = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double saturationTemperatureH2O_C = Double.valueOf(editTextEnthalpy.getText().toString());
                double result = _H2O_enthalpy(saturationTemperatureH2O_C);
                editTextEnthalpy.setHelperText("结果: " + result + "kj/kg");
            }
        };
        buttonRectangleEnthalpy.setOnClickListener(calEnthalpy);

        //计算水蒸汽的焓值
        editTextVaporEnthalpy = (MaterialEditText)view.findViewById(R.id.textfield_vapor_enthalpy);
        editTextVaporEnthalpy.setHelperText("");

        buttonRectangleVaporEnthalpy = (ButtonRectangle) view.findViewById(R.id.button_vapor_enthalpy);

        View.OnClickListener calVaporEnthalpy = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double saturationTemperatureH2O_C = Double.valueOf(editTextVaporEnthalpy.getText().toString());
                double result = _H2OVapor_enthalpy(saturationTemperatureH2O_C);
                editTextVaporEnthalpy.setHelperText("结果: " + result + "kj/kg");
            }
        };
        buttonRectangleVaporEnthalpy.setOnClickListener(calVaporEnthalpy);


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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
