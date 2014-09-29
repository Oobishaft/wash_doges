package com.umad.washdoges;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class main extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	Texture img;
	Texture aidun;
	Texture doge;
	Rectangle aidunRec;
	Rectangle dogeRec;
	Music hoseksi;
	Sound woosh;
	BitmapFont font;
	String scoreFinished;
	int score = 0;

	
	@Override
	public void create () {
		// Forces my fancy ass resolution
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);

		// Loads some crap, idk, you can delete. will work 100%, trust me ;)
		batch = new SpriteBatch();
		font = new BitmapFont();
        font.setColor(Color.RED);
		img = new Texture("background.png");
		aidun = new Texture(Gdx.files.internal("character.png"));
	    doge = new Texture(Gdx.files.internal("doge.png"));
	    hoseksi = Gdx.audio.newMusic(Gdx.files.internal("icejj.mp3"));
	    woosh = Gdx.audio.newSound(Gdx.files.internal("woosh.mp3"));
	    if(Math.random() <= 0.01)
	    	hoseksi = Gdx.audio.newMusic(Gdx.files.internal("rareashell.mp3"));
	    
	    scoreFinished = "0";
	    
	    // Makes aidun OP.
	    aidunRec = new Rectangle();
	    aidunRec.x = 400;
	    aidunRec.y = 20;
	    aidunRec.width = 30;
	    aidunRec.height = 80;
	    
	    dogeRec = new Rectangle();
	    dogeRec.x = 100;
	    dogeRec.y = 20;
	    dogeRec.width = 60;
	    dogeRec.height = 80;
	    
	    
	    hoseksi.setLooping(true);
	    hoseksi.play();
	}

	@Override
	public void render () {
		camera.update();
		scoreFinished = "" + score;
		// Doesn't render shit.
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(aidun, aidunRec.x, aidunRec.y);
		batch.draw(doge, dogeRec.x, dogeRec.y);
		font.draw(batch, scoreFinished, 620, 465);
		batch.end();
		
		// Self explanatory. 
		if(Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)) 
			aidunRec.x -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) 
			aidunRec.x += 200 * Gdx.graphics.getDeltaTime();
		
		if(aidunRec.x - dogeRec.x < 20 && dogeRec.x == 100){
			woosh.play();
			score++;
		    dogeRec.x = 700;
		    if(Math.random() <= 0.3)
		    	doge = new Texture(Gdx.files.internal("rare.png"));
		    else
		    	doge = new Texture(Gdx.files.internal("doge.png"));
		} else if (dogeRec.x - aidunRec.x < 20 && dogeRec.x == 700) {
			woosh.play();
			score++;
		    dogeRec.x = 100;
		    if(Math.random() <= 0.3)
		    	doge = new Texture(Gdx.files.internal("rare.png"));
		    else
		    	doge = new Texture(Gdx.files.internal("doge.png"));
		}
	}
}
