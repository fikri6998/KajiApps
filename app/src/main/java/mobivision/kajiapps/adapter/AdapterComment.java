package mobivision.kajiapps.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mobivision.kajiapps.R;
import mobivision.kajiapps.model.Comment;

import java.util.List;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.ViewHolder> {

    Context context;
    List<Comment> commentList;
//  RoundedBitmapDrawable rounded;

    public AdapterComment(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mUsername;
        TextView mComment;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_avatar);
            mUsername=itemView.findViewById(R.id.tv_username);
            mComment=itemView.findViewById(R.id.tv_comment);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Comment comment= commentList.get(position);

        holder.mUsername.setText(comment.getUsername());
        holder.mComment.setText(comment.getComment());
//        setupImageRounded();
        holder.imageView.setImageResource(R.drawable.ic_account_circle_black_24dp);

    }


    @Override
    public int getItemCount() {
        return commentList.size();
    }



}
