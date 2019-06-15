package santos.williankaminski.aprendaingles.Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import santos.williankaminski.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonUm;
    private ImageButton buttonDois;
    private ImageButton buttonTres;
    private ImageButton buttonQuatro;
    private ImageButton buttonCinco;
    private ImageButton buttonSeis;

    private MediaPlayer mediaPlayer;


    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        buttonUm = view.findViewById(R.id.buttonUm);
        buttonDois = view.findViewById(R.id.buttonDois);
        buttonTres = view.findViewById(R.id.buttonTres);
        buttonQuatro = view.findViewById(R.id.buttonQuatro);
        buttonCinco = view.findViewById(R.id.buttonCinco);
        buttonSeis = view.findViewById(R.id.buttonSeis);

        buttonUm.setOnClickListener(this);
        buttonDois.setOnClickListener(this);
        buttonTres.setOnClickListener(this);
        buttonQuatro.setOnClickListener(this);
        buttonCinco.setOnClickListener(this);
        buttonSeis.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonUm:
                playSound(R.raw.one);
                break;
            case R.id.buttonDois:
                playSound(R.raw.two);
                break;
            case R.id.buttonTres:
                playSound(R.raw.three);
                break;
            case R.id.buttonQuatro:
                playSound(R.raw.four);
                break;
            case R.id.buttonCinco:
                playSound(R.raw.five);
                break;
            case R.id.buttonSeis:
                playSound(R.raw.six);
                break;
        }
    }

    public void playSound(int sound){
        mediaPlayer = MediaPlayer.create(getActivity(), sound);

        if(mediaPlayer!= null){
           mediaPlayer.start();
           mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
               @Override
               public void onCompletion(MediaPlayer mediaPlayer) {
                   mediaPlayer.release();
               }
           });
        }

    }

}
