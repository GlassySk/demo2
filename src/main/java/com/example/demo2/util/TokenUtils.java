//package com.example.demo2.util;
//
//        import com.auth0.jwt.JWTVerifier;
//        import com.auth0.jwt.algorithms.Algorithm;
//        import com.auth0.jwt.exceptions.JWTCreationException;
//        import com.auth0.jwt.exceptions.JWTVerificationException;
//        import com.auth0.jwt.interfaces.DecodedJWT;
//
//
//        import java.util.Date;
//
//public class TokenUtils {
//
//    //token到期时间10小时
//    private static final long EXPIRE_TIME= 10*60*60*1000;
//    //密钥盐
//    private static final String TOKEN_SECRET="maixiaohua??#22**safdaf";
//
//    /**
//     * 生成token
//     * @param user
//     * @return
//     */
//    public static String sign(UserInfo user){
//
//        String token=null;
//        try {
//            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
//            token = JWT.create()
//                    //发行人
//                    .withIssuer("auth0")
//                    //存放数据
//                    .withClaim("username",user.getUsername())
//                    //过期时间
//                    .withExpiresAt(expireAt)
//                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
//        } catch (IllegalArgumentException| JWTCreationException je) {
//
//        }
//        return token;
//    }
//
//
//    /**
//     * token验证
//     * @param token
//     * @return
//     */
//    public static Boolean verify(String token){
//
//        try {
//            //创建token验证器
//            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
//            DecodedJWT decodedJWT=jwtVerifier.verify(token);
//            System.out.println("认证通过：");
//            System.out.println("username: " + decodedJWT.getClaim("username").asString());
//            System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
//        } catch (IllegalArgumentException | JWTVerificationException e) {
//            //抛出错误即为验证不通过
//            return false;
//        }
//        return true;
//    }
//
//}