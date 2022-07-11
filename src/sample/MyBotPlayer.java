package sample;

import java.io.*;
import java.util.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;



public class MyBotPlayer extends MyPlayer implements BotPlayer{
	Map map;
	MyPlayer player;
	Position fromIndex;
	Position toIndex;
	Scene scene;
	Food food;
	int[][]arr;
	Thread thread1;
	Thread thread2;
	Thread thread3;
	Thread thread4;


	public MyBotPlayer(MyPlayer player, Map map,Food food) {
		super(map);
		this.player = player;
		this.map = map;
		this.scene = scene;
		this.food = food;
		arr = map.getMap();
		
	} 
	@Override
	public void feed(Food f){
		System.out.println("Hello");
	}
	@Override
	public void eat(){

		 thread1 = new Thread(new Runnable(){
			  	boolean power = true;
				@Override
				public void run(){
					try{
						while(true){ 
						int switcher = 0;
						if(player.getPosition().getY() < food.getPosition().getY()){
								switcher = 1;
						}else if(player.getPosition().getX() < food.getPosition().getX()){
								switcher = 2;
						}else if(player.getPosition().getY() > food.getPosition().getY()){
							switcher = 3;
						}
						else if(player.getPosition().getX() > food.getPosition().getX()){
							switcher = 4;
						}
						switch(switcher){
							case 1: player.moveDown();Thread.sleep(400L);break;
							case 2: player.moveRight();Thread.sleep(400L);break;
							case 3:	player.moveUp();Thread.sleep(400L);break;
							case 4:	player.moveLeft();Thread.sleep(400L);break;
						}
				 	System.out.println(player.getPosition().getY() + "     " + food.getPosition().getY());
								// Thread.sleep(400L);
				 }
			 		}
						
					
					catch(Exception ex){
					}
				}
			});
		 thread1.start();
		 // 		while(true){ 
			// if(player.getPosition().getY() < food.getPosition().getY()){
			// 	thread1 = getThread1();
			// thread1.start();
			//  thread1.yield();
			//  thread1 = null;
			//  break;
			// }
			// else if(player.getPosition().getX() < food.getPosition().getX()){
			// 	thread2 = getThread2();
 		// 		thread2.start();
			//  	thread2.yield();
			//  	thread2 = null;
			//  	break;
			// } 
			// else if(player.getPosition().getY() > food.getPosition().getY()){
			// 	thread3 = getThread3();
			// 	thread3.start();
			// 	thread3.yield();
			// 	thread3 = null;
			// 	break;
			// }
			// 	else if(player.getPosition().getX() > food.getPosition().getX()){
			// 		thread4 = getThread4();
			// 			thread4.start();
			// 			thread4.yield();
			// 			thread4 = null;
			// 			break;
			// 	}
			// }

			
		}
		// if(player.getPosition().getY() > food.getPosition().getY()){
		// 	 Thread thread2 = new Thread(new Runnable(){
		// 		@Override
		// 		public void run(){
		// 			try{
		// 				while(player.getPosition().getY() != food.getPosition().getY()){
		// 					Platform.runLater(new Runnable() {
		// 						@Override
		// 						public void run(){
		// 							player.moveRight();
		// 							System.out.println(player.getPosition().getX() + " " + food.getPosition().getX());

		// 						}
		// 					});
		// 						Thread.sleep(1000L);
		// 				}
		// 			}
		// 			catch(Exception ex){
		// 			}
		// 		}
		// 	});
		// 	 thread2.start();
			
		// }
		// if(player.getPosition().getX() > food.getPosition().getX()){
		// 	 Thread thread3 = new Thread(new Runnable(){
		// 		@Override
		// 		public void run(){
		// 			try{
		// 				while(player.getPosition().getX() != food.getPosition().getX()){
		// 					Platform.runLater(new Runnable() {
		// 						@Override
		// 						public void run(){
		// 							player.moveUp();
		// 							System.out.println(player.getPosition().getX() + " " + food.getPosition().getX());

		// 						}
		// 					});
		// 						Thread.sleep(1000L);
		// 				}
		// 			}
		// 			catch(Exception ex){
		// 			}
		// 		}
		// 	});
		// 	 thread3.start();
			 
		// }
		// if(player.getPosition().getY() < food.getPosition().getY()){
		// 	 Thread thread4 = new Thread(new Runnable(){
		// 		@Override
		// 		public void run(){
		// 			try{
		// 				while(player.getPosition().getY() != food.getPosition().getY()){
		// 					Platform.runLater(new Runnable() {
		// 						@Override
		// 						public void run(){
		// 							player.moveLeft();
		// 							System.out.println(player.getPosition().getX() + " " + food.getPosition().getX());

		// 						}
		// 					});
		// 						Thread.sleep(1000L);
		// 				}
		// 			}
		// 			catch(Exception ex){
		// 			}
		// 		}
		// 	});
		// 	 thread4.start();
			 
		// }
	
	@Override
	public void find(){
		System.out.println("Hello");
	}

	@Override
	public Position getPosition(){
		return player.getPosition();
	}
	// public Thread getThread1(){
			
	// 		  thread1 = new Thread(new Runnable(){
	// 		  	boolean power = true;
	// 			@Override
	// 			public void run(){
	// 				try{
	// 					while(player.getPosition().getY() != food.getPosition().getY()){ 
	// 							player.moveDown();
	// 			 	System.out.println(player.getPosition().getY() + "     " + food.getPosition().getY());
	// 							Thread.sleep(400L);
	// 		 		}
						
	// 				}
	// 				catch(Exception ex){
	// 				}
	// 			}
	// 		});
			 
	// 		 return thread1;

			
		
	// }
	// public Thread getThread2(){
				
			 
	// 		  thread2 = new Thread(new Runnable(){
	// 		  	boolean power = true;
	// 			@Override
	// 			public void run(){
	// 				try{
	// 					while(player.getPosition().getX() != food.getPosition().getX()){ 
	// 							player.moveRight();
	// 			 	System.out.println(player.getPosition().getY() + "     " + food.getPosition().getY());
	// 							Thread.sleep(400L);
	// 		 		}
						
	// 				}
	// 				catch(Exception ex){
	// 				}
	// 			}
	// 		});
	// 		  return thread2;
			
			
	// }
	// public Thread getThread3(){
		
	// 			thread3 = new Thread(new Runnable(){
	// 		  	boolean power = true;
	// 			@Override
	// 			public void run(){
	// 				try{
	// 					while(player.getPosition().getY() != food.getPosition().getY()){ 
	// 							player.moveUp();
	// 			 	System.out.println(player.getPosition().getY() + "     " + food.getPosition().getY());
	// 							Thread.sleep(400L);
	// 		 		}
						
	// 				}
	// 				catch(Exception ex){
	// 				}
	// 			}
	// 		});
	// 			return thread3;
			
	// }
	// public Thread getThread4(){
		
	// 			thread4 = new Thread(new Runnable(){
	// 		  	boolean power = true;
	// 			@Override
	// 			public void run(){
	// 				try{
	// 					while(player.getPosition().getX() != food.getPosition().getX()){ 
	// 							player.moveLeft();
	// 			 	System.out.println(player.getPosition().getY() + "     " + food.getPosition().getY());
	// 							Thread.sleep(400L);
	// 		 		}
						
	// 				}
	// 				catch(Exception ex){
	// 				}
	// 			}
	// 		});
	// 			return thread4;
			
	// }
}
