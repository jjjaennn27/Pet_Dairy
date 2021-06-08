# 반려동물 앱 "부탁해, 집사 !" 🐕 🐈
## 1.소개
### 1-1 개발배경
간식으로 인한 비만 또는 산책을 안함으로써 생기는 배변 장애는 반려동물에게 흔히 나타나는 건강문제이다. 이를 해결하기 위해서는 가족의 의사소통과 무한한 관심이 중요하다. 그러나, 반려동물을 키우는 입장에서 혼자가 아닌 가족 구성원과 함께 관심을 가지고 모두가 케어해야 한다고 생각한다. 이러한 문제점을 토대로 기존 어플을 조사해보니 반려동물에 대한 어플 중 아직까지 가족들과 함께 공유할 수 있는 앱이 존재하지 않은 것을 확인하였다. 그 후 반려동물에 관한 앱을 개발함으로써 많은 집사들에게 활용적이게 사용할 수 있는 앱이 될 것 같아 주제를 선정하였다.
***
### 1-2 사용한 기능
부탁해 집사! 서비스 애플리케이션은 모든 가족 구성원끼리 반려동물을 케어 할 수 있게 가족연동을 통하여 반려동물들의 밥, 간식, 건강, 산책 등의 정보를 실시간으로 공유할 수 있다. 또한 google맵과 연동을 통하여 내 주변에 공원 위치와 병원 위치를 알 수 있게 함으로서 모든 집사들이 책임감을 가지고 반려동물을 편리하게 서비스를 제공 하는 것을 목표로 구성하였다.
Firebase을 Android Studio와 연결하여 테이터 저장을 통하여 여러 기능들을 구현하고 , 등Google API 연동을 통해 실시간 위치와 Place API을 이용하여 공원 위치와 병원 위치를 찾을 수 있도록 한다.
***
### 1-3 기존 어플과의 차이

***
### 1-4 기대효과
많은 가구에서 반려동물을 키우고 있어 반려동물 관리에 많은 관심이 쏟아지고 있는 요즘, 다양하게 반려동물에 대한 용품이나 그밖의 여러가지 관리를 위한것들이 나타나고 있다. 이에 걸맞게 많은 가구에서 유용하게 쓰여질 수 있는 반려동물 관리 어플을 만듬으로써 직접적으로 소통을 하지 않고도 정보 입력을 통해 서로 내용들을 공유하고 번거로움을 줄일 수 있으며 검색을 하지 않고도 주변 병원 또한 찾아볼 수 있어  가족 구성원이 좀 더 효율적으로 동물들을 보살필수 있을것이다. 그뿐만아니라 가족구성원이 각자 사진을 올리고 글을 작성하면서 가족간의 소통의 기회 또한 늘어나게 해줄것이라 기대한다.
***
## 2. 기능 구현
### 2-1 사용자 생성
#### 2-1-1 Firebase와 Android Studio 연동
 회원가입과 로그인 및 건강,산책,다이어리,가족연동 을 위해 데이터를 저장해 놓을 Firebase가 필요하다.
 
[연동 방법] 
1. 파이어 베이스에 프로젝트 생성
2. google-service.json파일얻기
3. .json파일을 안드로이드스튜디오 프로젝트 안에 삽입 
4. Firebase SDK추가
5. 안드로이드와 파이어베이스 연결 확인

[연동방법- realtime database]
1. TOOL에들어간후, 파이어베이스 클릭
2. realtime database를 찾은 후 클릭
3. Connect firebase를 하여 생성한 파이어베이스와 연동
4. add to realtime database to your app 을 클릭하여 자동으로 build.gradle에 코드가 추가되게 만들어줌
***
#### 2-1-2 회원가입
이메일로 회원가입을 진행할 수 있도록 하였다. 사용자의 이메일, 비밀번호를 입력하여 저장하여, 파이어베이스에 정보가 올라갈 수 있고도록 만들었다.   
Register.java 생성

    public class Register extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText mEtEmail,mEtpwd;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Family login"); //파이어베이스에 회원가입 정보 저장

        mEtEmail = findViewById(R.id.et_email);
        mEtpwd = findViewById(R.id.et_pwd);
        mBtnRegister = findViewById(R.id.btn_register);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입 처리시작
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtpwd.getText().toString();

                //파이어베이즈 어스 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(
                        Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);

                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(Register.this,"회원가입에 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this,Login.class); //회원가입 성공시 로그인 화면 전환 
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Register.this,"회원가입에 실패하셨습니다.",Toast.LENGTH_SHORT).show();
                            //회원가입 실패시 토스트 메시지 출력
                        }
                    }
                });
            }
        });
    }
    }

 UserAccount.java - 회원가입 정보을 저장해둘 class 생성
  
    public class UserAccount{
    private String idToken; // Firebase Uid( 고유토큰정보)
    private String emailId;
    private String password;
    public UserAccount() {    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    }
![image](https://user-images.githubusercontent.com/51051548/121134546-79c76300-c86e-11eb-8771-622d1352e113.png)
***
#### 2-1-3 로그인
 회원가입을 완료 되었다면 로그인을 할 수 있다. 파이어베이스에 있는 정보와 입력된 정보를 비교하여 등록되어있다면 로그인 성공 메시지가 뜨고 메인화면으로들어간다. 아이디나 비밀번호가 일치하지 않거나 등록되지 않은 아이디라면 로그인 실패 메시지가 뜨면서 화면이 넘어가지 않는다.   
 Login.java

    public class Login extends AppCompatActivity{
    private FirebaseAuth mFirebaseAuth; //파이어 베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터 베이스
    private EditText mEtEmail,mEtpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Family login");

        mEtEmail = findViewById(R.id.et_email);
        mEtpwd = findViewById(R.id.et_pwd);

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인요청
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtpwd.getText().toString();
                //파이어베이스 등록된 아이디 & 비밀번호 확인
                mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //로그인 성공
                            Intent intent = new Intent(Login.this,Family_Register.class);
                            startActivity(intent);
                            finish(); //현 엑티비티 파괴
                        }else{
                            Toast.makeText(Login.this,"로그인 실패",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입화면으로 이동
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }
    }
    
![image](https://user-images.githubusercontent.com/51051548/121136481-abd9c480-c870-11eb-9ae8-8f7c9949f719.png)
***
## 2-2 가족 연동
### 2-2-1 가족 구성원 프로필 입력 및 출력
한 아이디를 통해 가족들이 로그인을 하고 가족 구성원을 등록한다. 가족 구성원에 등록되면 스피너에 연결되어 밥 , 산책, 간식 팝업창에서 등록된 가족들을 선택하여 정보를 저장 할 수 있다.
등록이 되면 가족 구성원 프로필 리스트로 출력된다.   
Family_Register.java - 가족 프로필 등록

    public class Family_Register extends AppCompatActivity  {

    TextView tv;
    EditText Name;
    EditText age;
    EditText NickName;
    Button btn_pet, btn_pet2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family__register);

        tv = findViewById(R.id.tv);
        Name = findViewById(R.id.Name);
        age = findViewById(R.id.age);
        NickName = findViewById(R.id.NickName);
        btn_pet = findViewById(R.id.btn_pet);
        btn_pet2 = findViewById(R.id.btn_pet2);

        btn_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pet_Register.class);
                startActivity(intent);
            }
        });

        btn_pet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pet_Main.class);
                startActivity(intent);
            }
        });
    }


        public void clickSave (View v) {


            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference rootRef = firebaseDatabase.getReference("Family Pet");

            String name = Name.getText().toString();
            String Age = age.getText().toString();
            String Nickname = NickName.getText().toString();

            Person person = new Person(name, Age, Nickname);

            DatabaseReference personRef = rootRef.child("persons");
            personRef.push().setValue(person);

            personRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    StringBuffer buffer = new StringBuffer();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        Person person = snapshot.getValue(Person.class);
                        String name = person.getName();
                        String Age = person.getAge();
                        String Nickname = person.getNickName();

                        buffer.append("이름 : " + name + "\n" + "나이 : " + Age + "\n" + "별명 : " + Nickname + "\n\n");
                    }
                    tv.setText(buffer);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

    }
    
Person.java - 가족 정보를 저장할 class 생성

    public class Person {

    String name;
    String age;
    String NickName;

    public Person(String name, String Age, String Nickname) {
        this.name = name;
        this.age = Age;
        this.NickName = Nickname;
    }

    public Person(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String Age) {
        this.age = Age;
    }


    public  String getNickName() {
        return NickName;
    }

    public  void setNickName(String Nickname) {
        this.NickName = Nickname;
    }
    }
***
### 2-2-2 가족 연동
가족 구성원을 등록하면 밥, 간식, 산책에 가족들을 스피너로 연결하여 가족 연동을 구현하였다.   
Pet_Database.java

    public class Pet_Database { //데이터베이스에 저장된 가족 이름 연결
    public static void getPersons(OnSuccessListener<DataSnapshot> onSuccessListener) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference("Family Pet");
        DatabaseReference personRef = rootRef.child("persons");

        personRef.get().addOnSuccessListener(onSuccessListener);
    }
    }
 
Register_Food.java,  Register_Run.java, Register_Snack.java 파일에 넣어준다.

    private void setNameSpinner(Spinner nameSpinner) { //파이어베이스에 저장된 가족이름이 있다면 불러옴.
        Pet_Database.getPersons(dataSnapshot -> {
            List<String> persons = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                Person person = snapshot.getValue(Person.class);
                if (person != null) {
                    persons.add(person.name);
                }
            }

            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>( // 불러온 데이터를 스피너 값에 넣어줌.
                    this, android.R.layout.simple_spinner_dropdown_item, persons);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            nameSpinner.setAdapter(spinnerArrayAdapter);
        });
    }
    
    setNameSpinner(Person); //스피너에 저장된 스피너값 연결
![image](https://user-images.githubusercontent.com/51051548/121141133-99ae5500-c875-11eb-9157-f4f53856a070.png)
## 2-3 동물 등록 
### 2-3-1 동물 사진 등록 및 메인 화면에 불러오기
동물의 사진을 갤러리를 통해 직접 가져오거나 사진 촬영을 통해 등록할 수 있다.
그밖의 성별과 이름, 품종, 생년월일을 입력하여 등록을 완성한다. 저장이 완료 되었다면 등록된 사진이 메인화면에 출력된다.   
Pet_Register.java 

    public class Pet_Register extends AppCompatActivity {
    private Button btnCamera, btnGallery, btnSave;
    private ImageView animalImg;
    private ProgressBar progressBar;
    private EditText Name , Kind,birthday;

    final  int CAMERA_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pet__register);
        Name = findViewById(R.id.editTextTextPersonName);
        Kind = findViewById(R.id.editTextTextPersonName5);
        birthday = findViewById(R.id.editTextTextPersonName2);


        btnCamera = (Button)findViewById(R.id.btnCamera);
        btnGallery = (Button)findViewById(R.id.btnGallery);
        animalImg = (ImageView)findViewById(R.id.Animal_img);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnCamera.setOnClickListener(new View.OnClickListener(){
            // 카메라 연결
            @Override
            public void onClick(View v) {
                if(IsCameraAvailable()){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, CAMERA_REQUEST_CODE);
                }
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            //갤러리 연결
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 2);
            }
        });

        btnSave.setOnClickListener(view -> {
            //파이어베이스에 동물 정보 저장
            FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
            DatabaseReference rootRef= firebaseDatabase.getReference("Family Pet");
            String name = Name.getText().toString();
            String kind = Kind.getText().toString();
            String Birthday = birthday.getText().toString();

            Pet pet = new Pet(name, kind,Birthday);

            DatabaseReference PetRef = rootRef.child("pet");
            PetRef.push().setValue(pet);

            BitmapDrawable bitmapDrawable = (BitmapDrawable) animalImg.getDrawable();
            if (bitmapDrawable == null) {
                return;
            }

            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos) ;
            uploadImage(bos.toByteArray());

        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            animalImg.setImageBitmap(bitmap);
        } else if (requestCode == 2) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    animalImg.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void uploadImage(byte[] bytes) {
        //카메라와 갤러리에서 가져오기 성공 시 이미지뷰에 넣기
        progressBar.setVisibility(View.VISIBLE);
        PetStorage.uploadPetImage(bytes, onProgress -> {
            double value = (100.0 * onProgress.getBytesTransferred()) / onProgress.getTotalByteCount();
            int progress = (int) Math.round(value);
            progressBar.setProgress(progress);
        }, onSuccess -> {
            Toast.makeText(this, "이미지 등록 성공", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }, onFailure -> {
            Toast.makeText(this, "이미지 등록 실패", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        });
    }

PetStorage 함수 - 동물 사진 파이어베이스 저장

    public class PetStorage {
    //파이어베이스 스토리지에 이미지 저장
    private static final String TAG = "PetStorage";

    public static void uploadPetImage(byte[] data,
                                      OnProgressListener<UploadTask.TaskSnapshot> onProgressListener,
                                      OnSuccessListener<UploadTask.TaskSnapshot> onSuccessListener,
                                      OnFailureListener onFailureListener) {
        String uid = getCurrentUserUid();
        if (uid == null) {
            return;
        }

        StorageReference petImage = getStorageReference(uid);

        // async 비동기적으로
        UploadTask uploadTask = petImage.putBytes(data);
        uploadTask.addOnProgressListener(onProgressListener)
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }

    public static void getPetImageUrl(OnSuccessListener<Uri> onSuccessListener, OnFailureListener onFailureListener) {
        //이미지 가져오기 성공 시 파이에베이스 스토리지에 올리기, 실패시 기본 이미지
        String uid = getCurrentUserUid();
        if (uid == null) {
            return;
        }

        StorageReference petImage = getStorageReference(uid);
        // async 비동기
        petImage.getDownloadUrl()
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }

    private static StorageReference getStorageReference(String uid) {
        //가져온 이미지 url로 바꿔줌.
        final FirebaseStorage storage = FirebaseStorage.getInstance();
        //storageRef -> gs://project-pet-ba709.appspot.com/
        final StorageReference storageRef = storage.getReference();

        // userFolder -> gs://project-pet-ba709.appspot.com/uid/
        StorageReference userFolder = storageRef.child(uid);

        // return -> gs://project-pet-ba709.appspot.com/uid/petImage
        return userFolder.child("petImage");
    }

    @Nullable
    private static String getCurrentUserUid() {
        //파이어베이스에서 사용자 id 아이디 가져오기
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return null;
        }

        return user.getUid();
    }
    }
    
 Pet_Main.java 에 이미지 불러오기
 
      private void postPetImage() {
        //성공시 저장된 이미지 불러오기
        PetStorage.getPetImageUrl(uri -> {
            // 외부 라이브러리 Glide를 사용해서 Firebase PetStorage의 이미지 로딩
            Glide.with(this)
                    .load(uri)
                    .addListener(getRequestListener())
                    .into(petImage);
        }, exception -> {
            petImage.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.dog, this.getTheme()));
            progressBar.setVisibility(View.GONE);
        });
    }
### 2-3-2 동물 정보 저장
동물 정보 저장 완료후 메인으로 왔을때 등록한 동물의 이미지가 뜬다면 동물 등록에 성공하였다. 동물의 이미지와 함께 아래에는 동물의 건강, 밥, 산책, 간식의 정보를 등록할 수 있는 튼이 뜨고 이를 통해 정보를 작성할 수 있는 페이지로 이동할 수 있다.




