package com.wezhyn.learn.graph;

/**
 * 图处理算法简单热身
 * 构造一个与起点s先连通的子图
 *
 * @author wezhyn
 * @since 04.29.2020
 */
public interface SimpleSearch {

    /**
     * 获取起点位置
     *
     * @return s
     */
    int getStart();

    /**
     * 与s相连的顶点个数
     *
     * @return count
     */
    int count();

    /**
     * 判断 s 与 v 是否连通
     *
     * @param v v
     * @return true: 连通
     */
    boolean marked(int v);

}
