package com.atguigu.mybatis.bean;

/**
 * @author CYH
 * 自定义的 CYHPair
 * 没有实现 Map.Entry，可以正常工作
 */
public final class CYHPair<L, R> {

    public final L left;
    public final R right;

    public CYHPair(L left, R right) {
        super();
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

}
