package com.example.diagnoze.ui.tentang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aplikasi ini bertujuan untuk mendiagnosis suatu penyakit demam berdasarkan jawaban dari pertanyaan yang disediakan. Untuk lebih tepatnya dalam pengobatan dapat merujuk ke dokter.\n" +
                "\n" +
                "Diagnoze versi 1.0\n" +
                "\n"+
                "Kelompok 1 PAM-A Teknik Informatika UIN SUSKA RIAU\n" +
                "\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}