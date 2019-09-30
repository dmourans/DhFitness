package com.example.dhfitness;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

public class Opcao implements Parcelable {

    private String texto;
    private int imagem;

    public Opcao(String texto, int imagem) {
        this.texto = texto;
        this.imagem = imagem;
    }

    public Opcao() {
    }



    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
