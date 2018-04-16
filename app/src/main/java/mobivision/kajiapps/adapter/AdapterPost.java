package mobivision.kajiapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import mobivision.kajiapps.DetailPost;
import mobivision.kajiapps.R;
import mobivision.kajiapps.model.Post;

import java.util.ArrayList;
import java.util.List;



public class AdapterPost extends RecyclerView.Adapter<AdapterPost.ViewHolder> {

    Context context;
    List<Post> postList;

    public AdapterPost(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    public AdapterPost(Context context, ArrayList<Post> listPosts) {
        this.context = context;
        this.postList = listPosts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mUsername;
        public TextView mTitlePost;
        public TextView mPost;
        public ImageView mImagePost;
        public CardView cardViewPost;
        public TextView mLokasi;
        public TextView mWaktu;
        public TextView mUstadz;




        public ViewHolder(View itemView) {
            super(itemView);

            mUsername= itemView.findViewById(R.id.tv_username);
            mTitlePost = itemView.findViewById(R.id.tv_title_post);
            mPost = itemView.findViewById(R.id.tv_post);
            mImagePost=itemView.findViewById(R.id.img_post);
            cardViewPost= itemView.findViewById(R.id.cardViewPost);
            mLokasi = itemView.findViewById(R.id.tv_lokasi);
            mWaktu = itemView.findViewById(R.id.tv_waktu);
            mUstadz = itemView.findViewById(R.id.tv_ustadz);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_post,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Post post= postList.get(position);

        holder.mUsername.setText(post.getUsername());

        Glide.with(context)
                .load(post.getImagePost())
                .into(holder.mImagePost);

        holder.mTitlePost.setText(post.getTitlePost());

        holder.mPost.setText(post.getPost());

        holder.mLokasi.setText(post.getLokasi());

        holder.mUstadz.setText(post.getUstadz());

        holder.mWaktu.setText(post.getWaktu());



        holder.cardViewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPost.class);
                intent.putExtra("id",post.getId());
                intent.putExtra("Username",post.getUsername());
                intent.putExtra("image",post.getImagePost());
                intent.putExtra("Title",post.getTitlePost());
                intent.putExtra("Post",post.getPost());
                intent.putExtra("Lokasi",post.getLokasi());
                intent.putExtra("Waktu",post.getWaktu());
                intent.putExtra("Ustadz",post.getUstadz());



                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

}
