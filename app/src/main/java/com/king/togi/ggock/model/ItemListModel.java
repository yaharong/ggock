package com.king.togi.ggock.model;

import java.util.ArrayList;

/*
 * Created by Tacademy on 2017-08-08.
 */

public class ItemListModel {
    int success_code;   // ” : 1,\n"+
    ItemListModel1 result;   //” :  {\n"+

    @Override
    public String toString() {
        return "ItemListModel{" +
                "success_code=" + success_code +
                ", result=" + result +
                '}';
    }

    public ItemListModel(int success_code, ItemListModel1 result) {
        this.success_code = success_code;
        this.result = result;
    }

    public int getSuccess_code() {
        return success_code;
    }

    public void setSuccess_code(int success_code) {
        this.success_code = success_code;
    }

    public ItemListModel1 getResult() {
        return result;
    }

    public void setResult(ItemListModel1 result) {
        this.result = result;
    }

    public class ItemListModel1 {
        // depth 1
        String description;     //” : “상품리스트 조회결과\",\n"+
        ArrayList<ProductModel> message;      //” : {\n"+

        public ItemListModel1(String description, ArrayList<ProductModel> message) {
            this.description = description;
            this.message = message;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ArrayList<ProductModel> getMessage() {
            return message;
        }

        public void setMessage(ArrayList<ProductModel> message) {
            this.message = message;
        }

        public class ProductModel
        {
            // depth 2
            int prouct_no;          //”: 0,\n"+
            String category;        //” :”zz”,\n"+
            int hit;                //”: 3,\n"+
            int zzim;               //”: 10,\n"+
//            ArrayList<PlaceModel> place;        //”:[{\n"+
//
//            public class PlaceModel {
//                String address;        //파싱필요” : “48.842556, 2.351943”,
//                String name;           //” : “프랑스 어딘가”,\n"+
//                String description;    //” :  “good”\n"+
//
//                @Override
//                public String toString() {
//                    return "PlaceModel{" +
//                            "address='" + address + '\'' +
//                            ", name='" + name + '\'' +
//                            ", description='" + description + '\'' +
//                            '}';
//                }
//
//                public PlaceModel(String address, String name, String description) {
//                    this.address = address;
//                    this.name = name;
//                    this.description = description;
//                }
//
//                public String getAddress() {
//                    return address;
//                }
//
//                public void setAddress(String address) {
//                    this.address = address;
//                }
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public String getDescription() {
//                    return description;
//                }
//
//                public void setDescription(String description) {
//                    this.description = description;
//                }
//            }

            String name;               // “두통약”,
            String brand;              //“zzz”,
            int price;                 // 5000
//            ArrayList<CommentModel> comment;
//
//            public class CommentModel {
//                int comment_no;         //” : 0,
//                long reg_date;          //”:”2017-55-55.12:50:60”,\n"+
//                String content;         //” : “mmmm”,\n"+
//                String email;            //” : “hong@gmail.com”,\n"+
//
//                @Override
//                public String toString() {
//                    return "CommentModel{" +
//                            "comment_no=" + comment_no +
//                            ", reg_date=" + reg_date +
//                            ", content='" + content + '\'' +
//                            ", email='" + email + '\'' +
//                            ", depth=" + depth +
//                            '}';
//                }
//
//                public CommentModel(int comment_no, long reg_date, String content, String email, int depth) {
//                    this.comment_no = comment_no;
//                    this.reg_date = reg_date;
//                    this.content = content;
//                    this.email = email;
//                    this.depth = depth;
//                }
//
//                public int getComment_no() {
//                    return comment_no;
//                }
//
//                public void setComment_no(int comment_no) {
//                    this.comment_no = comment_no;
//                }
//
//                public long getReg_date() {
//                    return reg_date;
//                }
//
//                public void setReg_date(long reg_date) {
//                    this.reg_date = reg_date;
//                }
//
//                public String getContent() {
//                    return content;
//                }
//
//                public void setContent(String content) {
//                    this.content = content;
//                }
//
//                public String getEmail() {
//                    return email;
//                }
//
//                public void setEmail(String email) {
//                    this.email = email;
//                }
//
//                public int getDepth() {
//                    return depth;
//                }
//
//                public void setDepth(int depth) {
//                    this.depth = depth;
//                }
//
//                int depth;              //”:  “1”\n"+
//            }

            String pro_picture_url;     //” : “zzz”,\n"+
            String pro_explain;         //” : “zzz”, \n"+
            int similarity;             //”: 0 \n"+

            public ProductModel(int prouct_no, String category, int hit, int zzim, String name, String brand, int price, String pro_picture_url, String pro_explain, int similarity) {
                this.prouct_no = prouct_no;
                this.category = category;
                this.hit = hit;
                this.zzim = zzim;
                this.name = name;
                this.brand = brand;
                this.price = price;
                this.pro_picture_url = pro_picture_url;
                this.pro_explain = pro_explain;
                this.similarity = similarity;
            }

            public int getProuct_no() {
                return prouct_no;
            }

            public void setProuct_no(int prouct_no) {
                this.prouct_no = prouct_no;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public int getHit() {
                return hit;
            }

            public void setHit(int hit) {
                this.hit = hit;
            }

            public int getZzim() {
                return zzim;
            }

            public void setZzim(int zzim) {
                this.zzim = zzim;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getPro_picture_url() {
                return pro_picture_url;
            }

            public void setPro_picture_url(String pro_picture_url) {
                this.pro_picture_url = pro_picture_url;
            }

            public String getPro_explain() {
                return pro_explain;
            }

            public void setPro_explain(String pro_explain) {
                this.pro_explain = pro_explain;
            }

            public int getSimilarity() {
                return similarity;
            }

            public void setSimilarity(int similarity) {
                this.similarity = similarity;
            }
        }
    }
}
