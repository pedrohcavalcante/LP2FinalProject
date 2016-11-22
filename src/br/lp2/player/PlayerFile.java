package br.lp2.player;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

@SuppressWarnings("unused")
public class PlayerFile extends Thread{
	File music_fl;
	AdvancedPlayer player;
	
	public PlayerFile(File musicFile){
		this.music_fl = musicFile;
	}
	public void tocar(File mp3){
		this.music_fl = mp3;
	}
	public void Play() {
	}
}
