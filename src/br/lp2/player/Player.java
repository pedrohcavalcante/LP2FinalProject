package br.lp2.player;
import javazoom.jl.player.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

@SuppressWarnings("unused")
public class Player {
	 private File music;
	 private Player player;
	
	public Player(File musicFile){
		this.music = musicFile;
	}
	public void Play(){
		try{
			FileInputStream stream = new FileInputStream(music);
            BufferedInputStream buffer = new BufferedInputStream(stream);
            this.player = new Player(buffer);
            System.out.println("Executando...");
            this.player.Play();
            System.out.println("Terminado");
		}catch (Exception e){
			System.out.println("ops");
		}
	}
}
