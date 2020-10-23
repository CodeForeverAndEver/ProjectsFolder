PVector[] points = new PVector[6];

int WIDTH = 800;
int HEIGTH = 800;

float interval = 1;
ArrayList<PVector> inbetweenPoints = new ArrayList<PVector>();

void setup() {
   size(800, 800);
   
   for (int i = 0; i < 6; i++) {
      PVector currentPoint = new PVector(i, random(10));
      currentPoint.x = 100 + currentPoint.x * 600 / 5;
      currentPoint.y = int(100 + currentPoint.y * 600 / 10);
      points[i] = currentPoint;
   }
    
  
   for (int i = 0; i <= points.length - 2; i++) {
     PVector currentPoint = points[i];
     PVector nextPoint = points[i + 1];
     int numPointsInBetween = int((nextPoint.x - currentPoint.x) / interval);
     for (float j = 0; j < numPointsInBetween; j++) {
       float x = map(j, 0, numPointsInBetween, currentPoint.x, nextPoint.x);
       float mu = map(x, currentPoint.x, nextPoint.x, 0, 1);
       
       float y = cosineInterpolate(currentPoint.y, nextPoint.y, mu);
       inbetweenPoints.add(new PVector(x, y));
     }
   }
   
}

void draw() {
   background(255); 
   
   strokeWeight(5);
   stroke(0);
   for (int j = 0; j <= inbetweenPoints.size() - 2; j++) {
       line(inbetweenPoints.get(j).x, inbetweenPoints.get(j).y, inbetweenPoints.get(j + 1).x, inbetweenPoints.get(j + 1).y);
   }
   
   strokeWeight(25);
   stroke(255, 100, 100);
   for (PVector point : points) {
     point(point.x, point.y);
   }
   
}

float linearInterpolate(float y1, float y2, float mu) {
   return (y2 - y1) * mu + y1;  
}

float cosineInterpolate(float y1, float y2, float mu) {
   float angle = mu * PI; 
   float mu2 = (1.0f - cos(angle)) * 0.5f;
   return linearInterpolate(y1, y2, mu2);
}
