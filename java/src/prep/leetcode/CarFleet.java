package prep.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
	private static class Car {
        public int position;
        public int speed;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
	
	public int carFleet(int target, int[] position, int[] speed) {
		int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (x, y) -> Integer.compare(y.position, x.position));
        
        for(int i=0;i<cars.length;i++)
        {
        	System.out.println(i+": position-"+cars[i].position+": speed-"+cars[i].speed);
        }
        
        
        double last_arr_time=0;
        int fleet_count=0;
        for(Car c : cars)
        {
          double curr_arr_time = (target-c.position)/(double)c.speed;
          if(curr_arr_time>last_arr_time){
            fleet_count++;
            last_arr_time = curr_arr_time;
          }
        }
        
        return fleet_count;
	}

	public static void main(String[] args) {
		CarFleet cf = new CarFleet();
		System.out.println(cf.carFleet(10, new int[] {6,8}, new int[] {3,2}));

	}

}
