package santos.williankaminski.fragments.fragment;

/**
 * Created by Willian Kaminski on 19/05/19.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import santos.williankaminski.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConversasFragment extends Fragment {


    public ConversasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversas, container, false);
    }

}
