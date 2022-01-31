import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;


public class MonsterBattle extends JFrame{
	
	public MonsterBattle(){
		setSize(1000,650);
		setTitle("Monster Battle!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyJPanel myJPanel= new MyJPanel();
		Container c = getContentPane();
		c.add(myJPanel);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args){
		new MonsterBattle();
	}
	
	public class MyJPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	    Timer timer, timer2,timer3;
	    Image image,image2,image3,image4;
	    Image image5,image6,image7,image8, image9;
	    int my_x, my_y,my_xx;
		int mouse_x, mouse_y;
		int start_x, start_y;
		int init_x=80, init_y=490;
		double t=0.0, v=100.0;
		double v_x, v_y;
		int my_width, my_height;
	    int grab_flag=0;
	    
	    int released=0;
	  
	    
      
	    int j;
	    int hitokage_move, hitokage_movey, hitokage_width, hitokage_height;
	    int zenigame_move, zenigame_movey, zenigame_width, zenigame_height;
	    int fushigi_move, fushigi_movey, fushigi_width, fushigi_height;
	    int hitokage_x, hitokage_y;
	    int zenigame_x, zenigame_y;
	    int fushigi_x, fushigi_y;
	    int catchhito=0,catchzeni=0, catchfushi=0;
	    int caught=0;
	    int bossfight=0;
	    int clickcount = 0;
	    int my_X;
	    int player_width,player_height;
	    int enemy_width,enemy_height;
	   
	    int enemy_x;
	    int enemy_y;
	    int enemy_move, enemy_movey;
	    int enemy_alive=1;
	    int num_of_alive;
	    int[] my_missile_x ={0,0,0,0,0};
	    int[] my_missile_y = {0,0,0,0,0};
	    int[] missile_flagcomp = {0,0,0,0,0};
	    int[] enemy_missile_x;
	    int[] enemy_missile_y;
	    int[] enemy_missile_movex;
	    int[] enemy_missile_movey;
	    int[] enemy_missile_flag;
	    int missile_flag;
	    int enemylife = 15;
	    int playerlife = 10;
	    int n;
	    public static final int MY_Y=550;
	    Image image10,image11, image12, image13,image14, image15,image16,image17;
	    Image image18,image19;
	    int state=0;
	    int level=0;
	    
	    public MyJPanel(){
		int j,z;
		    my_X = 250;
		    missile_flag=0;
		   
		    n = 5;
		    num_of_alive = 3;
		    enemy_missile_x = new int[n];
		    enemy_missile_y = new int[n];
		    enemy_missile_movex = new int[n];
		    enemy_missile_movey = new int[n];
		    enemy_missile_flag = new int[n];
		    
		   
		    for(j=0;j<10;j++){
			hitokage_x = j+800;
			zenigame_x = j+500;
			fushigi_x = j;
	       
			hitokage_y = j+400;
			zenigame_y = j+200;
			fushigi_y = j;
		 
			hitokage_move = -10;
			hitokage_movey = -10;
			zenigame_move = -5;
			zenigame_movey = -5;
			fushigi_move = -1;
			fushigi_movey = -1;
		    }
		   
			for(z=0;z<n;z++){
			    enemy_x = 10*z;
			    enemy_y = 10*z;

			    enemy_alive = 1;
			    enemy_move = -2;
			    enemy_movey = -2;
			}
			for(z=0;z<n;z++){
			    enemy_missile_x[z]= enemy_x+enemy_width/2;
			    enemy_missile_y[z] = enemy_y+enemy_height;

			    
			    if(z==0){
				enemy_missile_movex[z] = 1;
				enemy_missile_movey[z] = 3 + z%3 ;
			    }
			    if(z==1){
				enemy_missile_movex[z] = -1-z%3;
				enemy_missile_movey[z] = 1+ z%3;
			    }
			    if(z==2){
				enemy_missile_movex[z] = 1+z%3;
				enemy_missile_movey[z] = 1 + z%3;
			    }
			    if(z==3){
				enemy_missile_movex[z] = 3+z%3;
				enemy_missile_movey[z] = 1+z%3 ;
			    }
			    if(z==4){
				enemy_missile_movex[z] = -3-z%3;
				enemy_missile_movey[z] = 1+z%3 ;
			    }
			    enemy_missile_flag[z] = 1;
			}
			
	        
			
			ImageIcon icon = new ImageIcon("assets/ball.png");
			image = icon.getImage();
			ImageIcon icon2 = new ImageIcon("assets/fushigi.png");
			image2 = icon2.getImage();
			ImageIcon icon3 = new ImageIcon("assets/hito.png");
			image3 = icon3.getImage();
			ImageIcon icon4 = new ImageIcon("assets/zeni.png");
			image4 = icon4.getImage();

			ImageIcon icon5 = new ImageIcon("assets/firemon.png");
			image5 = icon5.getImage();
			ImageIcon icon6 = new ImageIcon("assets/watermon.png");
			image6 = icon6.getImage();
			ImageIcon icon7 = new ImageIcon("assets/leafmon.png");
			image7 = icon7.getImage();

			ImageIcon icon8 = new ImageIcon("assets/back.png");
			image8 = icon8.getImage();

			ImageIcon icon9 = new ImageIcon("assets/player.png");
			image9 = icon9.getImage();
			
		
			ImageIcon icon11 = new ImageIcon("assets/enemy.png");
			image11 = icon11.getImage();
			ImageIcon icon12 = new ImageIcon("assets/enemyheart.png");
			image12 = icon12.getImage();
			ImageIcon icon13 = new ImageIcon("assets/playerheart.png");
			image13 = icon13.getImage();
			ImageIcon icon14 = new ImageIcon("assets/purplefire.png");
			image14 = icon14.getImage();

			ImageIcon icon15 = new ImageIcon("assets/fire.png");
			image15 = icon15.getImage();
			ImageIcon icon16 = new ImageIcon("assets/water.png");
			image16 = icon16.getImage();
			ImageIcon icon17 = new ImageIcon("assets/leaf.png");
			image17 = icon17.getImage();
			ImageIcon icon18 = new ImageIcon("assets/win.png");
			image18 = icon18.getImage();
			ImageIcon icon19 = new ImageIcon("assets/lose.png");
			image19 = icon19.getImage();
	     
			player_width = image3.getWidth(this);
			player_height= image3.getHeight(this);
	    
			    
			enemy_width = image11.getWidth(this);
			enemy_height= image11.getHeight(this);
			setBackground(Color.black);
			addMouseListener(this);
			addMouseMotionListener(this);
			
			my_width = image.getWidth(this);
			my_height = image.getHeight(this);
			my_x = init_x;
			my_y = init_y;
			fushigi_width = image2.getWidth(this);
			fushigi_height = image2.getHeight(this);
			hitokage_width = image3.getWidth(this);
			hitokage_height = image3.getHeight(this);
			zenigame_width = image4.getWidth(this);
			zenigame_height = image4.getWidth(this);
			
			timer2 = new Timer(50, this);
			timer2.start();
			
			
	    
		}
		
		public void paintComponent(Graphics g){
		    super.paintComponent(g);
		    if((bossfight==1)&&(state==0)){
			g.setColor(Color.white);
			g.drawString("Level:" +level, 10,15);
			if(catchfushi==1){
			g.drawImage(image2,my_X,550,this);
			}
			if(catchhito==1){
			    g.drawImage(image3,my_X,550,this);
			}
			if(catchzeni==1){
			    g.drawImage(image4,my_X,550,this);
			}
			for (int j=0; j<enemylife;j++){
			    g.drawImage(image12,30*j+20, 20,this);
			}
			for (int p=playerlife; p>0;p--){
			    g.drawImage(image13, 970-30*p, 600,this);
			}

			if(enemy_alive== 1){
			    g.drawImage(image11,enemy_x,enemy_y,this);
			}
			for(int i=0;i<n;i++){
			    if((enemy_missile_flag[i] == 1)&&(enemy_alive==1)){
				g.drawImage(image14,enemy_missile_x[i],enemy_missile_y[i],this);
			
			    }
			}

			for(int k=0; k<5; k++){
			    if(missile_flagcomp[k]==1){
				if(catchhito==1){
				    g.drawImage(image15,my_missile_x[k],my_missile_y[k],this);
				}
				if(catchzeni==1){
				    g.drawImage(image16,my_missile_x[k],my_missile_y[k],this);
				}
				if(catchfushi==1){
				    g.drawImage(image17,my_missile_x[k],my_missile_y[k],this);
				}
			    }
			}
		    
		    }
		    if(bossfight==0){
		   
		     g.drawImage(image8,0,0,this);
	    
		    
	    
		    g.drawImage(image3, hitokage_x, hitokage_y, this);
		    g.drawImage(image4, zenigame_x, zenigame_y, this);
		    g.drawImage(image2, fushigi_x, fushigi_y, this);
		    
		    
		       
			g.setColor(Color.black);
		       
			 g.drawImage(image,my_x,my_y,this);
			 	g.drawImage(image9, 70,445,this);
			
			if(grab_flag==1){
				g.drawLine(85+my_width/2,515,mouse_x,mouse_y);
			}
		
			
			if(catchhito ==1){
			    g.drawImage(image5, 0, 0, this);
			    caught=1;
			}
			if(catchzeni==1){
			    g.drawImage(image6,0,0,this);
			    caught=1;
			}
			if(catchfushi==1){
			    g.drawImage(image7,0,0,this);
			    caught=1;
			}
		    }
		    if(state==1){
			g.drawImage(image19,0,0,this);
			g.setColor(Color.white);
			g.drawString("Score:" +level, 500,100);
		    }
		    if(state==2){
			g.drawImage(image18,0,0,this);
		    }
		}
		
		public void actionPerformed(ActionEvent e){
			Dimension d;
			d=getSize();
			Dimension dim=getSize();
			if((bossfight==1)&&(state==0)){
			    enemy_x +=(level+1)*enemy_move;
			    if( (enemy_x < 0) || ( enemy_x> (dim.width - enemy_width) ) ){
				enemy_move = - enemy_move;
			    }
			    enemy_y +=(level+1)*enemy_movey;
			    if( (enemy_y < 0) || ( enemy_y> (dim.height - enemy_height) ) ){
				enemy_movey = - enemy_movey;
			    }
			    for(int i=0;i<n;i++){
				if(enemy_missile_flag[i]==1){
				    enemy_missile_y[i] += (level+1)*enemy_missile_movey[i];
				    enemy_missile_x[i] += (level+1)*enemy_missile_movex[i];
				    
				    if (((enemy_missile_y[i] > 650))||(enemy_missile_x[i] < 0)||(enemy_missile_x[i] > 1000)||(enemy_missile_y[i] < 0)){
					enemy_missile_flag[i] = 0;
				    }
				}else{
				    enemy_missile_x[i] = enemy_x+ enemy_width/2;
				    enemy_missile_y[i] = enemy_y+ enemy_height/2;
				   
				    enemy_missile_flag[i] = 1;
				}
				if (enemy_alive == 1){
				    if( ((enemy_missile_x[i]+2) >= my_X) &&((my_X+player_width) > enemy_missile_x[i]) &&( (enemy_missile_y[i]+5) >= MY_Y ) &&((MY_Y + player_height) > enemy_missile_y[i])){
					enemy_missile_flag[i]=0;
					playerlife--;
					if(playerlife==0){
					    state=1;
					}
				    }
				}
			    }


			    for(int j=0; j < 5; j++){
				if(missile_flagcomp[j] == 1){
				    my_missile_y[j] -= 15;
				    if(0 > my_missile_y[j]){
					missile_flagcomp[j] = 0;
				    }

				    if(enemy_alive == 1){
					if( (enemy_x <= my_missile_x[j]) &&
					    ( my_missile_x[j] < (enemy_x+enemy_width)) &&
					    ((enemy_y+enemy_height) >= my_missile_y[j]) &&
					    enemy_y < (my_missile_y[j]+5) ){

					    missile_flagcomp[j] = 0;
					    
					    enemylife--;
					    if (enemylife == 0){
						state=2;
					    }
					}
				    }
				}
			    }
			    
			}
			if(caught==0){
			
			hitokage_x += hitokage_move;
			if ((hitokage_x < 0)||(hitokage_x > (dim.width - hitokage_width))){
			    hitokage_move = -hitokage_move;
			}
			hitokage_y += hitokage_movey;
			if ((hitokage_y < 0)||(hitokage_y > (dim.height - hitokage_height))){
			    hitokage_movey = -hitokage_movey;
			}
			zenigame_x += zenigame_move;
			if ((zenigame_x < 0)||(zenigame_x > (dim.width - zenigame_width))){
			    zenigame_move = -zenigame_move;
			}
			zenigame_y += zenigame_movey;
			if ((zenigame_y < 0)||(zenigame_y > (dim.height - zenigame_height))){
			    zenigame_movey = -zenigame_movey;
			}
			fushigi_x += fushigi_move;
			if ((fushigi_x < 0)||(fushigi_x > (dim.width - fushigi_width))){
			    fushigi_move = -fushigi_move;
			}
			fushigi_y += fushigi_movey;
			if ((fushigi_y < 0)||(fushigi_y > (dim.height - fushigi_height))){
			    fushigi_movey = -fushigi_movey;
			}
		
			
	        
			if (released ==1){
//-------------------------------------------------------------------
			    t+=0.2;
			my_x = (int)(v*v_x*t+start_x);
			my_y = (int)(9.8*t*t/2 - v*v_y*t+start_y);
//-------------------------------------------------------------------
			
			if ((hitokage_x<=my_x)&&(my_x<(hitokage_x+hitokage_width))&&((hitokage_y+hitokage_height)>=my_y)&&((hitokage_y)<my_y)){
			    catchhito =1;
			    
			}
			if ((zenigame_x<=my_x)&&(my_x<(zenigame_x+zenigame_width))&&((zenigame_y+zenigame_height)>=my_y)&&((zenigame_y)<my_y)){
			    catchzeni =1;
			}
			if ((fushigi_x<=my_x)&&(my_x<(fushigi_x+fushigi_width))&&((fushigi_y+fushigi_height)>=my_y)&&((fushigi_y)<my_y)){
			    catchfushi=1;
			}
			if((my_x<0)||(my_x>d.width)||(my_y>d.height)||(my_y<0)){
				timer.stop();
				released =0;
				my_x=init_x;
				my_y=init_y;
				t=0.0;				
			}
			grab_flag=0;
			}
			}
			repaint();
		
		}
		
		
		public void mouseClicked(MouseEvent me)
		{
		   
		    if(caught==1){
			bossfight=1;
		    }
		    if(state==1){
			System.exit(0);
		    }
		    if(state==2){
			
			state=0;
			enemylife=15;
			playerlife=10;
			level++;
		       
		    }
		}
		
		public void mousePressed(MouseEvent me)
		{
		    if(caught==0){
			mouse_x = me.getX();
			mouse_y = me.getY();
			if((grab_flag==0)&&(my_x<mouse_x)&&(mouse_x<my_x+my_width)&&(my_y<mouse_y)&&(mouse_y<my_y+my_height)){
				grab_flag = 1;
				start_x = mouse_x;
				start_y = mouse_y;
			}
		    }
		    if((bossfight==1)&&(state==0)){
			if(clickcount < 5){
			    if(missile_flagcomp[clickcount] == 0){
				my_missile_x[clickcount] = my_X + player_width / 2;
				my_missile_y[clickcount] = MY_Y;
				missile_flagcomp[clickcount] = 1;
				clickcount++;
			    }
			    if(clickcount == 5){
				clickcount = 0;
			    }
			}

		    }
		}
		
		public void mouseReleased(MouseEvent me)
		{
		    if(caught==0){
			if(grab_flag==1){
				timer = new Timer(100, this);
				timer.start();
				released = 1;
//-------------------------------------------------------------------
				v_x = (double)(start_x-mouse_x)/100;
				v_y = -(double)(start_y-mouse_y)/100;
//-------------------------------------------------------------------
	       
				start_x = my_x;
				start_y = my_y;
			   
			}
		    }
		}
		
		public void mouseExited(MouseEvent me)
		{
		}
		
		public void mouseEntered(MouseEvent me)
		{
		}
		
		public void mouseMoved(MouseEvent me)
		{
		    if((bossfight==1)&&(state==0)){
			my_X = me.getX();
		    }
		}
		
		public void mouseDragged(MouseEvent me)
		{
		    if(caught==0){
			if(grab_flag==1){
				mouse_x = me.getX();
				mouse_y = me.getY();
				my_x = init_x - (start_x-mouse_x);
				my_y = init_y - (start_y-mouse_y);
			}
				repaint();
			}
		}
	}
}
