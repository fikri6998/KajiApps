package mobivision.kajiapps.screen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobivision.kajiapps.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

import mobivision.kajiapps.adapter.PostAdapter;
import mobivision.kajiapps.model.Post;


public class FragmentMyPost extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Post> listPosts;

    Query databasePost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_post, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser current_user = mAuth.getCurrentUser();

        databasePost = FirebaseDatabase.getInstance().getReference(MainActivity.table1).orderByChild("userID").equalTo(current_user.getUid());

        listPosts = new ArrayList<>() ;

        return view;
    }

    public void onStart() {
        super.onStart();
        databasePost.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                listPosts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Post post = postSnapshot.getValue(Post.class);

                    listPosts.add(post);
                }

                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

                PostAdapter postList = new PostAdapter(getContext(), listPosts);

                recyclerView.setAdapter(postList);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
