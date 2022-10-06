package com.djx.demo.leetcode.everyday;

import java.util.Arrays;

/**
 * @author djx
 * @date 2022/7/13 下午3:15
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        for (int i = 0; i < asteroids.length - 1; i++) {

            int left = asteroids[i];
            int j = i;
            for (; j >= 0; j--) {
                left = asteroids[j];
                if (left != 0) {
                    break;
                }
            }
            int right = asteroids[i + 1];
            // 碰撞
            if (left > 0 && right < 0) {
                if (left + right == 0) {
                    asteroids[i] = 0;
                    asteroids[i + 1] = 0;
                } else if (left + right > 0) {
                    asteroids[i + 1] = 0;
                } else {
                    asteroids[i] = 0;
                }
            }

        }

        int count = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                count = count + 1;
            }
        }

        int[] result = new int[count];
        int i = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                result[i] = asteroid;
                i++;
            }
        }

        return result;
    }

    public int[] asteroidCollision1(int[] asteroids) {

        for (int i = 0; i < asteroids.length - 1; i++) {

            int negative = asteroids[i];
            if (negative < 0) {
                for (int j = i - 1; j >= 0; j--) {
                    int num = asteroids[j];
                    if (num < 0) {
                        break;
                    } else if (num > 0) {
                        if (num + negative > 0) {
                            asteroids[i] = 0;
                            break;
                        } else {
                            asteroids[j] = 0;
                        }
                    }
                }

            }

        }

        int count = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                count = count + 1;
            }
        }

        int[] result = new int[count];
        int i = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                result[i] = asteroid;
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] array = {2, -1, 1, -2};

        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] result = asteroidCollision.asteroidCollision1(array);

        System.out.println(Arrays.toString(result));
    }

}
