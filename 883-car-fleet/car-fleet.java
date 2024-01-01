class Pair {
    int pos, speed;

    Pair(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}

class Solution {
    boolean willCollide(int target, Pair nextCarParam, Pair carParam[], int idx) {
        if (carParam[idx].speed > nextCarParam.speed) {
            double deltaPos = (double) (nextCarParam.pos - carParam[idx].pos);
            double deltaSpeed = (double) (carParam[idx].speed - nextCarParam.speed);
            double deltaTime = deltaPos/deltaSpeed;
            double collisionPoint = deltaTime * (double) nextCarParam.speed +
                    (double) nextCarParam.pos;
            if (collisionPoint <= (double) target)
                return true;
        }
        System.out.println(idx+ " "+ "false");
        return false;

    }

    public int carFleet(int target, int[] position, int[] speed) {
        int numberOfCars = position.length;
        Pair carParam[] = new Pair[numberOfCars];
        for (int idx = 0; idx < numberOfCars; idx++) {
            carParam[idx] = new Pair(position[idx], speed[idx]);
        }

        Arrays.sort(carParam, (a, b) -> (a.pos - b.pos));

        Pair nextCarParam = carParam[numberOfCars - 1];
        int noOfCarFleets = 0;
        for (int idx = numberOfCars - 2; idx >= 0; idx--) {

            if (willCollide(target, nextCarParam, carParam, idx))
                continue;
            noOfCarFleets++;
            nextCarParam = carParam[idx];
        }

        return noOfCarFleets + 1;

    }
}