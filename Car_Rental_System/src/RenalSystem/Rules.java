/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RenalSystem;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface Rules {
    int add(ArrayList<String> inputs);
    int update(ArrayList<String> inputs);
    int delete(String id);
}
