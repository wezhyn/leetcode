package com.graph;

/**
 * 寻找s到v之间连接的路径
 *
 * @author wezhyn
 * @since 04.29.2020
 */
public interface SimplePathSearch {

    /**
     * s 到 v 之间的路径
     *
     * @param s start
     * @param v end
     * @return path
     */
    String path(int s, int v);

    /**
     * 是否又路径
     *
     * @param s start
     * @param v end
     * @return true: 连通
     */
    boolean hasPath(int s, int v);
}
