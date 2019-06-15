package santos.williankaminski.aprendaingles.Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import santos.williankaminski.aprendaingles.Activity.MainActivity;
import santos.williankaminski.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimaisFragment extends Fragment implements View.OnClickListener{

    private ImageButton buttonCao;
    private ImageButton buttonGato;
    private ImageButton buttonLeao;
    private ImageButton buttonMacaco;
    private ImageButton buttonOvelha;
    private ImageButton buttonVaca;

    private MediaPlayer mediaPlayer;

    public AnimaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_animais, container, false);

        buttonCao = view.findViewById(R.id.buttonCao);
        buttonGato = view.findViewById(R.id.buttonGato);
        buttonLeao = view.findViewById(R.id.buttonLeao);
        buttonMacaco = view.findViewById(R.id.buttonMacaco);
        buttonOvelha = view.findViewById(R.id.buttonOvelha);
        buttonVaca = view.findViewById(R.id.buttonVaca);

        buttonCao.setOnClickListener(this);
        buttonGato.setOnClickListener(this);
        buttonLeao.setOnClickListener(this);
        buttonMacaco.setOnClickListener(this);
        buttonOvelha.setOnClickListener(this);
        buttonVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCao:
                playSound(R.raw.dog);
                break;
            case R.id.buttonGato:
                playSound(R.raw.cat);
                break;
            case R.id.buttonLeao:
                playSound(R.raw.lion);
                break;
            case R.id.buttonMacaco:
                playSound(R.raw.monkey);
                break;
            case R.id.buttonOvelha:
                playSound(R.raw.sheep);
                break;
            case R.id.buttonVaca:
                playSound(R.raw.cow);
                break;

        }
    }

    public void playSound(int sound){
        mediaPlayer = MediaPlayer.create(getActivity(), sound);
        if(mediaPlayer != null){
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
