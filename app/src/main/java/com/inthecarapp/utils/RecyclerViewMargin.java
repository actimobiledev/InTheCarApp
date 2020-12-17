package com.inthecarapp.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.IntRange;
import androidx.recyclerview.widget.RecyclerView;

import com.inthecarapp.R;


public class RecyclerViewMargin extends RecyclerView.ItemDecoration {
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int LAYOUT_MANAGER_LINEAR = 0;
    public static final int LAYOUT_MANAGER_GRID = 1;
    public static final int LAYOUT_MANAGER_STAGGERED = 2;
    private final int columns;
    private final int rows;
    private int margin_top;
    private int margin_bottom;
    private int margin_left;
    private int margin_right;
    private int orientation;
    private int layout_manager;

    private Drawable mDivider;
    private Context context;
    private boolean divider;


    /**
     * constructor
     *
     * @param margin_top desirable margin size in px between the views in the recyclerView
     * @param columns    number of columns of the RecyclerView
     */
    public RecyclerViewMargin(Context context, @IntRange(from = 0) int margin_top, @IntRange(from = 0) int margin_bottom, @IntRange(from = 0) int margin_right, @IntRange(from = 0) int margin_left, @IntRange(from = 0) int columns, @IntRange(from = 0) int rows, int layout_manager, int orientation, boolean divider) {
        this.context = context;
        this.margin_top = margin_top;
        this.margin_bottom = margin_bottom;
        this.margin_left = margin_left;
        this.margin_right = margin_right;
        this.columns = columns;
        this.rows = rows;
        this.orientation = orientation;
        this.layout_manager = layout_manager;
        this.divider=divider;
        mDivider = context.getResources ().getDrawable (R.drawable.line_divider);
    }

    /**
     * Set different margins for the items inside the recyclerView: no top margin for the first row
     * and no left margin for the first column.
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        switch (layout_manager) {
            case LAYOUT_MANAGER_LINEAR:
                switch (orientation) {
                    case ORIENTATION_HORIZONTAL:
                        outRect.top = margin_top;
                        //set right margin to all
                        outRect.right = margin_right;
                        outRect.bottom = margin_bottom;
                        if (position == 0) {
                        }

                        //we only add top margin to the first row
                        if (position < rows) {
                            outRect.left = margin_left;
                        }
                        //add left margin only to the first column
                        if (position % rows == 0) {
                        }
                        break;
                    case ORIENTATION_VERTICAL:
                        outRect.right = margin_right;
                        //set bottom margin to all
                        outRect.bottom = margin_bottom;
                        //we only add top margin to the first row
                        if (position < columns) {
                            outRect.top = margin_top;
                        }
                        //add left margin only to the first column
                        if (position % columns == 0) {
                            outRect.left = margin_left;
                        }


                        break;
                }
                break;
            case LAYOUT_MANAGER_GRID:
                switch (orientation) {
                    case ORIENTATION_HORIZONTAL:
                        break;
                    case ORIENTATION_VERTICAL:
                        //set bottom margin to all
                        outRect.bottom = margin_bottom;
                        //we only add top margin to the first row
                        if (position < columns) {
                            outRect.top = margin_top;
                        }
                        //add left margin only to the first column
                        if (position % columns == 0) {
                            outRect.right = margin_left / 2;
                            outRect.left = margin_right;
                        } else {
                            outRect.right = margin_left;
                            outRect.left = margin_right / 2;
                        }
                        break;
                }
                break;
            case LAYOUT_MANAGER_STAGGERED:
                break;
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (divider) {
            int left = parent.getPaddingLeft ();
            int right = parent.getWidth () - parent.getPaddingRight ();

            int childCount = parent.getChildCount ();
            for (int i = 0; i < childCount - 1; i++) {
                View child = parent.getChildAt (i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams ();

                int top = child.getBottom () + margin_bottom / 2;
//            int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight ();

                mDivider.setBounds (left, top, right, bottom);
                mDivider.draw (c);
            }

        }
    }
}