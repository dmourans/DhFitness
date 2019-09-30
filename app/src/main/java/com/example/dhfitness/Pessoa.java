package com.example.dhfitness;

import android.os.Parcel;
import android.os.Parcelable;

import static com.example.dhfitness.CadastroActivity.NOME_KEY;

public class Pessoa implements Parcelable {
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private int imagem;

    public Pessoa(String nome, int idade, double peso, double altura, int imagem) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.imagem = imagem;
    }

    public Pessoa() {
    }

    public Pessoa(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    protected Pessoa(Parcel in) {
        nome = in.readString();
        idade = in.readInt();
        peso = in.readDouble();
        altura = in.readDouble();
        imagem = in.readInt();
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
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
        parcel.writeString(nome);
        parcel.writeInt(idade);
        parcel.writeInt(imagem);
        parcel.writeDouble(peso);
        parcel.writeDouble(altura);
    }
}
