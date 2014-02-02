/*
 * The MIT License
 *
 * Copyright 2012 SBPrime.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.PrimeSoft.blocksHub;

import org.bukkit.entity.Player;

/**
 * @author SBPrime
 */
public class PermissionManager {
    /**
    * List of all permissions
    */
    public enum Perms {
        ReloadConfig, 
        ShowStatus
    }
    
    /**
     * Plugin permissions top node
     */
    private static String s_prefix = "BlocksHub.";

        /**
     * Check if player has a specific permission
     * @param player player
     * @param perms permission to check
     * @return True if permission pressent
     */
    public static boolean isAllowed(Player player, Perms perms) {
        if (player == null) {
            return true;
        }

        String s = getPermString(perms);
        if (s == null) {
            return false;
        }

        return player.hasPermission(s);
    }
    
    /**
     * Convert permission to string
     * @param perms Permission
     * @return Permission node
     */
    private static String getPermString(Perms perms) {
        switch (perms) {
            case ReloadConfig:
                return s_prefix + "admin.reload";
            case ShowStatus:
                return s_prefix + "admin.state";
        }

        return null;
    }
}