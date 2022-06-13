<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="scroll-behavior: smooth;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoesel</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="https://th.bing.com/th/id/OIP.WGyHTn_3yK52VkIhkRBarAHaEs?pid=ImgDet&rs=1" rel="icon"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol style=" position: relative;"class="breadcrumb">
                                <li class="breadcrumb-item"><a href="home">Home</a></li>
                             <div class="right-contact">
                              <a href="https://www.facebook.com/TechStore365" class="right-contact-link">
                                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAK4AAABDCAYAAAAF1j6yAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAArqADAAQAAAABAAAAQwAAAACJvFwQAAAu60lEQVR4Ae19CYAVxbX2uffOCgMMIKsgWzARXABFjTHqQ41iDPpHMYmamBhRk2jMM5qXuPwZNVGTuOT5lLjFfd9R44oCKqKASxBQFFlkWId99rv+33eqTt++d+7MgIp58Z8aus/pqlOnzqn6+nR1dd9GpCN19MC/YQ9E/g1t7jD5X9cDhfCSn5cpYF6hvAJi256V3+i21+yQ/P+lByKd71vbuymePCoVie4TiUgfoLCPSKQvwNM3k5EM8tZKJr02k5a1UfDpVPwtadj4rJx9xVrXSSNRpcrAa/Qz9V8HcD9T9315KxffXTMmlUr9n0wmc5REIqMlk4mABxsB67BnPClTTnkkwgrvZtLJ54oTyScSPzv1bZFeqPgwK9um9T7NrgO4n6bXvsR1iu9YtXcyFbkE2Po2oio8JcYMJsaTMhcgxh9poWRlpJJOPRerq7s0+Z/XzhXZlBYJorBTVkhBG3mFW2yjQkfRl7MHSm5ds3sqkr4Ml/tjAxzm4jSAsCGNgZbB1wfcgPcBOYjOFpEpEJH0U9H1Gy9J/O6y99CTqU8bgTuA++XE4XZ5VXzLqtMRAv8HoC0xMKoCosPACzY/wuZE1G1oMagficSjDfXnJa497RZZVgvwDkXzD2PT1rZBU/YasE3CHUL/kh7YYcHlK89kSpauWDMZkfBU9SwPqBZNgwgKoRCOwbtpgk4FUJY/5w2EfYhuIZ9M3t1l6mO/3PzE6w2ozui7zeDdYZ2iHdGx+7Q9gHGpwrYAW82OGaM/XtUr1q3Pk4KVAgWUXe/DFlv4tTJDrQeiTiksj/VaIB2mW15Yr/Eog8Q7RfPmfbdp6nWrZXEjwDsdmyZrxaRz6I7plJwmOg62pQeqMplo43o5AbInYgOYpDcGPZa9KBpCbDw5dJa3DS1EENEymZpMKv127Ya6J259cf2ktMTGRrB+lZEomonyHxIu6AEqctvIWTWgJIrbwqWzPWtjy/puhSKazrxV+vBd4+tWvFAryyQJ8DLycms1BSa2KtFRsMN74LzNmSGpZnkkk0mPcYPdPijyQdDSyFzQZUHugF+zoVmenbFattYj3kaBWN14nhC42waL/KlBezYFc1wN1bQoNNVIxKd0/cPPf7Sxa2Pcg5eR187SFu7B0o70r+yBs9ZkhiQTmTdTmcxXLMyQJtMZDTmkKGuxpTH4Tgb36ZDf3q20LCbDB3eVJYs3SbwZQQ4QUcBmCC+ePkbJu01lwCucKE9YhWgL3stafY3OrOLrmR6l0djX4vuNK0u//NKr0ieZkc1jIbWQGgqmDuAW7JYvJrMK04PNtempSYA2hWEKbwQij1sDpJVl6xDcrGMgN9705pYT+JEiPALrUy4fLtig4MQzMEwXALM0IjB0KXRpABOOdSbhKcHIpHmOdTrAG1CdDmSgTpi3cqtLqvqKSr5e/LU9Xku9Mbda+jdlZONo1CwMXpjekf5VPbBsVeqETJrTAyYOHUdYh7DF/LHFZThvgulq680OlSGqgUcmaTaFeIZL/OvSs0wGDa6Q5UvqJFrM6A24xgAlTh0Q7Qle02G1jeZazFZyc3KmAlqa/8DC6Xd+OyszPQZcKs31R0htDKdMd2xVaI5bbvq0EZcWdmyfsQ9G/OriyzEyX2VQY6QkaCxiVkYzcnbPqPyoMia7Iry815CUOk4bIEu5btif3bNITqmMyleLRebVJ6U2lfblIt0ivry7K3/Pl7Mt3QAFowR49eIt0OqGlMCNIJb6I8UVca45njpZnwedmgxepNjCUwnl2YLKUDM7L0uVZ51orH90j/0/Ss965UPpBYe2LkTuMq2llfxueyOua8lVBl/l1XDZpiNtbw/EM+l9OMBBCkXHn1ZGZDcAUtJpGVEq8tNKkcvWxBEVkQmkndYrKiNKUBl1dgvKEznluxWjHGDfrcTqu/IIo2koVexULhG0k0mkEGhjkk4A0gh4lGPUDBJRx0OHvizvRTTCoyqpS2S0gjtU/5Dn/STROjn1MxLr1uvC4r59nmnYsD4pXylPy+IqaK2iDi8psq3ANVNAq2Tjxl8OqKioOKaoqOgoTOiHQmF/bBXU/L8h5V9W8+9+t9fGz1uftX/c0mau/RRMQ4pw2QaYmDhaw0qi0tzcBGAh7sViMgQjl0RAsjSU5fFmiXJZy5e3qO/Lo9BtgCGNom6G04Io9EFnBNGegGfLesNmjSBLgcAiJMKf4LPTwHiPS5ZSDMloLm+6lKLIzgecNYPTE878ltx08ZPSUGJru7a+SyVBm3rQyo56sVVFNmzY0D+Vuvjm7t27LykuLr4OTh2Jsl2x5YDWDCd1G85b5UmdE0bZpvGkYZ5l25LCdciHgWodb5T6vAlKw7y1Fc4j7/Q5anqMWp0wza/v/HJ+hm0tA0ASEC60vd+YBIZw6cdGAC6oa5Z4KiUJAIsby5lv20KUNyeSkkAeN60PuRS2NLYFtaifTEJHWuIAZXirgy6dN3BocIcXIYjJh6jyBDPz/KZgB0/KjWVGw3Wpy/SpDGzAerK7a0QdzGp0c/rQT9TVqdv4ivJMkcQjMRmJy4s+kMn2cltzXA9YgnZipLn52gmIslNRdX9sdpJlNYU4N9AwCKczz2iYFdAw78qQ4xkn724GTIeqZblDkDvEHq65s19zsjp4GNbni/OIs81pySvy9e0EcE07eQNdyxq5OWa784dlhf1/pyEly+N2t+/G0VYJ/ok56UBEwK7o6ffq4nLNqlqpwwUyjalCGlH3vYa0DMSId9PyhFyzslYaoiiLQQZRdx50B/XrUR/ldVhGyBQV67ot22G8Jt20sl7WL97KjuMcE6PLCzEiN6M3zWdn64YdVh7cGU8JBwNK8Y/J1/D1fC7qKBgB1tNGdZY/H1op769tllVbE6rPD7/Xgb7mX6y4b+bt525ONqbx4KQYc90amJtdYXCtaZMtdizDNjESj997NiLs1WoXdjao2YGkKD0zdcaTFkrtybdXnq+zPfnc8rzzoF1/tlc+2xdt+/9ybVouXRtXZxCrdMBINTGaJhOSiaOcY4fAEyvFZDXm5rhsI5NIYD7qygm4SEkJMOfKHVASkmr25Zg+RIpRDuDnz3E/fmmVbPi4FqijTKmCW3AC6MoCAkavThE5c58K2bt/iWzACXHz3Fp5ozquASIDcEc98iy2kDJZv9HWCsy3Jx/dU47brZPmXzZto1zx6mYIuXb0ZGcdbNZrkRUfHFf01HWv1CZqm6QGlwx5izMrLW4t4rI+tomRhoY7J5SWlv49jTVH5Plk6p1YfqeHS7WCd0wtVh5tGzWVbdKwRvJMRsN8oTznqWnQqthZ59hxmLKsbXkrJc0u8RjowqWqtxX/B5dE5JXapKxLAqSISrqyAMorJR8uEKxpbCmCFYBL6THagz4s0YNGEX0hw3IANkUe9nDT1QeUZwDYNKNsUQnkoAsxkeX28KJ2XZNUv44fKjC6Up7RlsthjKZoo39nkZdP6SNHf7VchnUvkt17l8gpoyqkZ2lGZixpwFQEVekfZPUKow6zV5BFR4DikTsVyTMn95YDB5VpwZamtJz5SLU0JFCuMRoR1nSwPnVxKyqpkbdeei2RiqZk585p2Xgyou50VqJ1LRLbRJoY+fjjK3cuLy+/M53OYFmal3C1A2XoVK3OnYsURk3OqMphZ5SM8aTKe93OXd+8uk47KKONKSWvrRp1EppHG7g5cUfJayd62lK7q6XtaG3KE4yOmh9Gw7qtPZaRJzU5oyqPnVEyWR4rBX1LpBNGKY4I6+adpGm9acOFVJIEW1ERKDYCFi1wvAncJICWBFhTLOOGMitXGZQnUM6yBKYXCa3r2uK8uqEBT1dfXAmQ0FoAF6DVyM1XJNgBQOUtE3rIYACWNutGT8GfsV+lvPSTfjKkCw4Q+XlTl8EJaPMP8pwL/3CPcplxah8Z1oM64Dt8u/DpFbJ2cyOuGAigaCOD+Qo3gtWozokjxbtm0o1wkE40opN19UqHsBBwYVoVCmsigwYN+j0a68KTgZ6Q6omBBow6h9xgqGHIcGUhedTWPNWS5ZkXlrX62hoV+0QZJpNnp2oeRUzMqApyh8R6vm5AkWWqne1O5PHHn5B9x46VG//2N1m3bq3Mf4/vObsGXPshf5DNPKvv7OYx+2H7/N8ZUfe2gYhmmAUQbNkbNeNdfjOAwXJSbgS5UeU98JtBuYXzyFOvUfJ1Nc2y9PFPJFHL0wNTBICWEZ6xDMUKqJP3LJeDh5ThCsAMt2kUBU+6V99SmfmzAXLsrjAe05oIpzSwDXeM0imWkZsmVMpkAL8MqxjWNzOX1ModiPB4sUaHJKonDfqT6lHVqPJFRUMy6SJcIpqiEu8CrGbflOMsPJz8UC+ILF16+wCs6Z3CBlsmDhBFrcx40gKJYiYC1moZZY2CzbAAyYHBOa8ZQI3a5RAV8FlbGTGtUdSwtlsxr6amRubMmS1XXnmljBs3Tq699lp5++235e6779HmWu4+T/8jMgDjfs8u5fLM5oQ8jRuWhbhh24wIxMs9PXEJxuNNb+cMc8w/X27jodTVCKryEEBJNQL865ukbjFu5JbVASTAAm7ouHabwVwzAh5zBa28U6eY/OHw7jouOX2J0vBYVeDEu+v7/eTmNzbKhc9v0ZPpq71K5c4TesoITCsU6DQdlRLw6ZwHFjs3+GgZkV1xlAav/6wl8ynaA2dQpEuXTpHaVDMkarG5lA9c5FZhmx7p06ffMWjMzYEpbv0EFl56MAR6kOn4mTNnymuvvSoLFy6Uvn37ylhEseOPnyhLly6V6667TsrKyuTyK65QffUN9XLxRRdRo1xy6aWCVQvl162tAYgggzRp0umy24jdtLOmz5ghT06Zovn5u2OOOVYOPvhgzV68eLFMnnwDomJEqqoukS5dqBeXUSwHXYT2mpub5fzzz5d+/fvL3LlzZcb06bJq1Sq544475JFHHlHbDz30UNV10003yqJFi2TChGPkkP84RPPa8p8C7gQKnWiEn4627y+ScH/iMBaLyFGVRfKtLpif4jIbx2WUy1hczuJwGgCoP6jrx1fzCuzY5p5/XSNNnFeEE/olGsHZgukDN420mFbwHQVnVkYuP6yb9ChHsIMOmksrmAqYTutk0n7d5fDhFTJvdbMcvmtnKcfjY+ez9YfINS9+IouwmoC5qztJdKaKKQrxBPUah4yiLdxWdZZMaSSTaoYh3SA0GLlvYct9AEGbkDiPqMVqRGy8O3YNuzmbM17zQ6yWoeWHHnxIrr76Kqsm77//vkybNk0Wf/yxHDX+KAD6NenUqZMaSWcT8YTmsUKcd79+Nfjhhx8K8nFjqEBnG9UrVgT5QSOe4QliacjQIULwrlmzRp58coqcdNJJaC2jtrz00ksyfPhw6devnzyB6cEVV1wedLDV79atm5wHYDPNnz9f3nzzTdl7bzzkUvB5qQL+00aXcinbtj5iOQdK80LRkeVRRKFiRL4irO/GeIVEhNJ1WgWPq+MbyCGm29q39lK4dMczAChOCibuabYeYadWEbiaA+CikK2MG1osJ+wFzKBdc9Mo9YT5YM4E1A3qUSyDMB9mXk5foc7idY1y1QuYTwtPGDzqY4THFIUR11kHvZw+sC6oJlwCMpkUfixchkxG3E0U5RZeKXCibh4xFCsm0aGaU2BnDQVa4MoyRFQD7TnnnCPPv/CC3Hb77RoFf3zKjyGRddc6tlBec1OzPPbYY7iJLhYCiMBfvXq11j/u+OPlueeflwceeDCw6kGcLM8j77vfPQ55bAOvRWMwjocs06OPPoq9s/ihhx7SvBNOOEGWLVsul1/+R+3gX/3qV9DxgtwwebJUVlbKli1b5L5771XZQrtC/jOP/hT6CwMrzJus5fGpVwy2RwG0EqwElJQUSWlpsZSXleBK5Sj5TmWlmkfq+OKAlgdyTr5ruYtunAYgGmmkC2gExx5AXJPl/BJBVv5yNKYI6o/zPjtyroeZa+W82VKeNMzn1f/P+z7EFQ/Ko1iSQ5tRtI0DQBd5BCpByxPZU/LRVKqBbWlKJ6zb9RC1wqnKH9Th7bZIPz3j/KWCPGvqAKEdo8jWNGvWLKWMfCeeeJICYOSIkfLnP/8Fr87h+xFerqmpSc44/XQ5/fRJ8utzz3WVufflTz/9tNTW1sphhx2ml2dGnAcfBFBRzmkGntopoK0iwV1Z2R2DjPkUZMweTh0Yraurq4W2MQK/++67WvfI8ePljTecvfvss4/84MQTpbJ7pZA/9dRTVfWrr76qoLZ2aEBb/lu7Ku99UZ/UJu5oG6CqRjreynPq4IBAZvQliHXD8lRAwWuZp+R5omYpZLXM0c6ljGzuL4O5JP9IjbcbIt5UcRXg/IM7y2BbAaC9yKPNtXjJ58FZq2XRqjrNQyadUGsDSt0+z3zlVOOematl5uJ6TElKYSeW5vAgRdtH3OQqAm0wO4zyJEJZnfZNgV2BOS4nwOU0zl+4vX2orDZ5JWGeWRs3btKSbohYLRJH3CcCkQAqlOjs/fffp0Xjxh0qPXv2xA3SXTqvnXTaJOlcgUVFppC+gGce+9Gnrl27yhFHHql1H330EeneA/N8JAKaIF+/foMeV+JE0Hq+PiMuU0ND9mTXDOzCPod5K2+Vmm1mtx9vs9cNNvVnHTBe1zetXms0T5/1CUG6C+bNa7cQGd5NyAatBAwLM7iZisovDuzqZL0t1PHu8q1y6i0fyPINTTiBInLxMYPlrMMHqFxWm1NGeaxKY++MXYfnBr9/fJlGWr35E0R5xFlGW64o8KpjsvQZcT/oh0gqtdI3AnG+MZRNeRHX3vJqBOBz5LI1CnD0kdGKac7s2VK9sloHmTqmT5+mvpk+znFfww3czJmvy9P/+EegjeWcA6/APJbp/PPPQ/T7ifL19fU6V1WT0JYNKguNNxrOmzhxotan3ueefVYjk04hoMPmxLMxf6W91J3Aks5TiPhM++67r9Jt2fkxdj7TPv4ZpWLPk4Z5ldNMVydoKwxQ8qxnlLqccqXmt1HqCPO79sA8ErjlxncCjJLXyzLzNNqm5eoJ3QBMZCO4WLp9xkoZ/5d/yicbsUIcxdIYouYlU1bLiZPfl431eLLnnSflxghrlPzFDy+VzQ0wPjQ9IHAJWmuftNAWSTYvoR2RCF4q19SdVPkCEdeJhPc0RCfNoJqsE0mReMaM2XuMgmHOnDnyox/+UPbaay+dm3I14bjjjtfo56TxEAjzNyaj5KkjiLa4ox88aDByM1hTXSecPnC68L3vfV/BR/m2kzNs+PBdZfTo0fLOO+/oSsK4cePctAWVx4wZI/vtt5/eeNHeUaNG6coHVxcY6Tmfzk/sB00F/CcIg8jhOTe5MC2+s3BockYpEea1v5Fj7bHM8kxb29TaisiIfohw6UYvbjY6P5xeREf4der+nWTMQDzuJYiQ6pqS8ut7F8vjb+HKFCvV+bF73Exkp2TqB3EZd/lCufnUITJ2qIvSrhHfR+iP6Qs3yaNz8OuKIrw2yVUMzqkxTdBVGSecs9c1XJiuFCWZ+rp/RiJYEKaBka1QHArAOTXzDoKIwDs9/KF1t9E28qTckIrwdObaa/+qN0mMqq+//rouMe2//9fllFNOgZwXhCwHwTatjN2SJUt0aYrz0gsvuBBz4NPljDPOlAvAE0i8QZs27WWtZ3WM2gCbTg4bedKJE08wMeVNJoYnUldffY3wRo3LcFzG403ZAd/4htxy662Chy/qs1mttA3/rR+0MfOV1Ptq1Npvi4aBGuatDtsgb8l4Kw/7f8gwgA6irW8Z6Ye1/d8d0TUYzoWrGuRbV86Tx+Zg+qcrANARBfgQcSMRbEV43yBWhpdkonLMXz+U65+vRpTmCogbV9LFaxrkrDs/RqDhzSHqA7iYjevGtyY5n7Y30fRNH8x19ebMU6wxZ5IfvTlVIkm8M1SEOQRfPuZjOpfooyXwE3E6LcHWJZZIvmSnqXa+A6qvpz2Dalab2ZZHbRjgDevX67ySNw5QkC8QyiOLcj0RtlV/bvVs496gfH0Qz0nWFqlPmzZt0htKnVNaptF8fearVW/hHgqsjupoIYBcyyML3myifLv6c6u3qOD18S6fIBrzx7WyCvNcBh89EbRtNot2MXc499DO8uvDXdR88M318rv7l0sTH9NFER0ZbYuwfEWeG5PWw+ORFKYKaTx5SzbLyP7F8qMDe0qPipjMw8ONe16vkU0NGPtiAB0glxiXwfiQg/Pbwsmu6joGyfi7TY+c+91IMhNvTCQapWvXRqkWrJm6j4Z4SwoognHsWibtRxzbOLXoqBYxPiM9d+oJB1HZ6/Ex2+tzupnHxD2vBkF7YFyeFqMwDwiQDfK0vrPNNLS01+sxwvpMRsF2t5tKb4fqUCHvLfK3x3/faapBfYFHvlUUfUH+64mZkWNHlckN0+p9l8EP74jOd2HhC/MbZO+BMXkcEfbhN2pQjsiIpbMMLu1RAI5P1YA89JeBjp4AlLhR07VYTIwXrIrLfz2wCjJ+fsxlNujAK2sAK6lfs0VVu0LYSUTKxF5x/Q6hui2Itgm8TwSFMbzQUFYHxbpeoN3YKnBZagNlvNbQFjwXGng2a0kbx6HVt/zWqMkZpSbV4SsYqEmDFOaDzPaZlXhy8z93r1T9vzxlgPTthUiQl6zt1uwJAJ9jQ9Y2rf+/xH9GrxP36SSTX653N0NELS/TSOof+AXVCTn5RqyVp/CqIi7tWuJBy5sqXuIJVAMYyx3I+H4DVgd4RwdgptMAaQbvK6hyyBOwGqUBM4CeWmy5iywNsJjnD112JJJOrp73bKS5OB0taUZo74Sf7+B1NP3C48Mq0ypwWercU/3Kq6M+n7yVUzacLN8oywrxQR4BwA71QMi5ZPi6Oe3lybOunsXUEWpr+uzN8tAzjCAi/3X6LjKwX6nc8+Q6ufOxtXL4N3pIPw9a2hHWb3YZtTKn3fliedpg3s7qGWVxPn/NbdXy8SeN0menErn457tgkKHxc/Zf24Taob2L5Ni9SmXKO03aT+aHmq1CBB4AShOAJD6U0AgJMLqlKxbQiawXqoMrAwpHUP7jQw4AVxMArQo1UhP0FHHjFJwAqg8lXi+1Uy4dr3s8+c9Hl6FPUnUNiLZdqJQvklcFBrQJ3KxCqrNA7rRbmzhyDavXXq/xpEiutqM8NgMDK5gZSpZvlEVh3nUIMr1+rRrmkfHh0kaZdOGH6kIDPkn1/uIGeXzySHng6XVSXhqVP547yNxTw9ryJ3sBc/7Qobbk1S4KtOL/jfevlqtuXSFdOsekth5vyELfRb8YpG5wZ74aDeepkPlqlJlhXoWyO1p9wdEV8uJ7zXgHFgdqvLoNls4AZNx4I6WNgoeTBK3eMJkqllGZGcYpBXTpIXlyunIQCECYMlbH9WSggDaH+wk8glZTfMEz10pzJoWl25QURZJSgjfu9aPQ0OMTLSycTCGUq2meKg9DjKrVagDUkFLO1yXVDUUBDfO+PFxHdVjbpCbjqeoO5bFck1EcbMYbVpMuXITHoFF57IYRct3/HS5Lq5vk3MuXyCv3jZL5z42VAf3cS81uIKBDB8S1l2OD91ttVK8p8+n9nzFns/zp5k/koLGVMufxMTLh0J5yy4Or5fEX1gf9pz5pnzp7wj6HeZUzv436/mWfqCwoo3n/bkXys//gr3kBDqjNbgQo/zglwMaoqdMDB1oFHaetBTZdGUA+Vwncuiz06PosYIUXdvjH9WJrK5gmmC57akaqqwkgdZtuyyydsRo/2ARwY0kpSqbcp0iDL5nTNdiaTeCzqwrx+FSsKkChJh1VcE6coKWrCl4vESZWRsqUL99e+cy5W+Wqv1fLb88YIPuP4t1u2+23mFpgEC2P7efWdl5Znit3vpi9hSSyeS39oY5was+/9svDrVGzWUvasn3zlVTL8/wnwFMAbH1TQg69YoNUbyRycpMDOfuNsazwuNu55JvJOb9ytRU+ard+OrWybvaNR0WrF27BfV1zfaKkSSo3N8myXrhOuNUE09zqVEEdcf0QcsQ7BMK5UNi/P920Qq67K7tAbA0Y3blPqcy4fy/5yrjZmrXfXl3lsckjlJ+3qE7Gnzpf+ZOO6S377tFVZs/bisjJ+ZID1VW3Vsu1t1erzH9fNEyOH99L+bXr4zLmmLeV3+trFfLMrbvrOHMh/TFEsbMvXaxlsx4eLYP6I8pqoh8ROegH72Ce2YT8Upl27yjB+yyajj9rocx6Fz8eRPpw6r7SmW+eaMrgEp9nx5GwA/20tgZ2HBuy4++7yze9ftb/aOp+Ol057JR5XldLctrEfnLJrwbJn2+plr/e4XydcuPuss8eFWgiIrc/tlouvHqZVrzmgmHyvW+7PtCHBrDBHh7QHsujsK4SRFLSqaRYrv9RNznx+k3SgHd+wycQeQi6yOqRSQzYSaGNtoM8k23tBPLoCWBDnZaHB8V1ieWzTovWzMOriSXJaEkxPgKBR3PLdgUIbqaYiaopNiJ6kLODD60mKyM1vlXhbSgImbTwowb5+yNrtFIvfKnFovoR38Q7BT5NexM/svNpxptbjJXxh0DG7AF94kVcfn2a8tJ6vXTa5dMoi5evapa/3YeTbhv8aWGHb2/G7JAdB2dttfbD7VleQRrqC5ZfcM1SjWzWDwXrhHwO+2+yBkDibtSgErnhlC5Swom1Thsc1ZUGvXTDgODSjTK9hAPW9ojW03Bdlmm5l83WhwWah66FWidnlHUCPpXa+NHZ8fkPfBhJ8JdG8URtIy4PXTBV0P8vIhe09KtV4OZ0tHUmKTYt89TkdsZvp/bds6tu3brYep/I6BEVmjd6BN/vZJMtUzj7nYV1Mu+DOtTpgrpdnDAE9vhqZ2HUZiJIuFzItqeHQHzkN92LNMzfvDWpck6ByJQX3Us1dpxPr79rlVSvcXfd+WVBt9EOvCQdtoML/Ew5dhzk7MjRAwyE/eyFd1etv+gr+V12xiPXHCm8Hf1hvdz9OH7MyBRWwEP4af1vVMV8R4fLmW9vnB08slyuOAEvLEGfzlOpl3yIKqgU2E7G5rNGdb5K3zmHpRx56vDU8V6vyoBXOUfDfGbr6kubZl3/Cj6wn4wWlcXrmjvFpVNFwn3oOXeKgNqaWp0qwASTaUH1soJco+ygkyf0kZMm9FbZk3/9AQbSRaC7/vI16YE3lOhIYzx3buX7V69Q1sjh3+guF5w5UIYPwWNFZrr+0E494qDuctvDa2TTlqS8C3CP2q1CXpnr2hmGn74MH1Su8qz2D/z8OcnI4dP7HzfIR8sbZfhgvPmGhvWyZoWgjc34qfj1n8hNl+0ayi3MHgk7/u7tmPdBvez5tc6BHUO9HWEgqRYOakjduK9XytW/G6Y5+VfgkJiyf7plhXxnXE92RZDI2yVZQaJKguKgHzSHDbN9RFneMMVw1h+7Xyf8YDElVz3dmLWLMl7WadJWXGXs3Xi7KYaWQ1bB7h3TdXYoyK63s4bpyOrWNqgvI43JzZ9c2DT7L1McaFPx+uZIXDpn4vjVAKLtdwCY6VTQIrUacdV+DLANgFFqsKhAyj9nnqPOuWw7KkE9/DOkajHt8VvItN49iwFa3P36dliPidQiKo+nvbFZIzNBzHTEQZUq4+Qj8sRUN00owU9ILDHP2YDuzLHFSRDsvDF0drk8kzPK3PB04WXYMX9RvZ5MLBsPUNMGGzLmMTHP2eaON+D3ZW8vqHXb/FpZuLgu1B2hDoE4rx5XYiUiP9Em3ajZ+hg8Iebaou/mq1H8ugLvlfD93kmHV0ivzpDhCe4v6UY14uoUgACDN36KYDQcMXXlgDEpiKyepynMA1WAh9rAW+WfNFe/dnwuaPEEpAwfilhVRtBibltFDQVTqxE33MnGG6WmMF9Qc06mgyE7MZtcp/K4AIYcsMLikOMNXWXXIh1IRnS+G2pp/EF4xOzT2g0JmfUOAQj3EanmvFcrn2AeO2XqBjnvpwPUCvZItraK6u6i/14q3bC+Gk7mq9FcOzbn2VFgmhAoy7Y4deZm4WZpGK4WM+7Z0w5b0Hvx4OR7R7krWrbQ9Jk3rY5zUIVRmrX4sjn5vvgUzvotvh4GQksLDQjqWJnTgIw8+fbLfZ1E4/MNC+/7bWr93C2c00aLy1ykLUekXduNK80G2lYdajXitmI7dLZMFo2yESAro3qwMxoqUXBqXev/oBAZmscdNzcwMbzhdtgB7sbnnYW18uRLbt7Kp0+jdvMvmUP6qZcZWZ2yb+Gm7lsHOjAtXdEk8xAdnb2MQE6GDySs/kd4cPHWAkS/NhJeLAvZUdfCDurVNrx+qmrpf14DlDV3nfMq8PXRXA509R98Zp3ybsc+dZsrzzbm/HM2ZH3NaUBfD+UXaMqKAQHOS0Pzz9YiqJNDa16e0TSbB/PZRDjCet7JoSze/Gpi9Zzjal/5r5+nVr67KZIsieuyVzzaLJ2xBaAtPK+FhiC1GnEDCTDsdM5LtPPDBZ63MlImT7I8MvRyESownSpEh0OJne10ugLjSY/8ZqU88lwNnouLfIAvqTAdgbxwehKRlYkvpg3GUlc9PhtkiVF3T9xgwRvLUrkrzx8iR502X/Xm+2m2hvPZZkE7vK85nYCW1PWQ/7wh+/7RbjmLhnQNR/lQQ5O+11c2bk7KoqUNrfZ/4IhnrBmj9NXxWZ/Zl4y4Zfh9mwIury4Prb5RL9I6IfgpTGAjuXqZJN4eez21adENDQtvnSuRVDqSSOPhQlECH5JO1jbF4vg+U8LPaduNtKoYu1aBC6fqAKAKM0AHz9eiWTQq2w2+IFRuOZSxcSjF5yy74wkO56ULcbMUx3dYi/GxiLdDEa4/Vg5UNyo6x1nfXcJID9qvm5QhQjbhZsrSET6isp1q/Dza9BHcR/j1YZN9ClH6op8PhFLT7kpGDu8kP/lu32ApzuSps4U9KDwEX3JpYYetaqA8V7vrK+qyNHhAmUwcv5M/1BaCfjIZUvbP5ecNkuN+8X442yn0OabXKMGjdnsjjLdyrUz/gdhSXD0YYZk4FeLlnpRpaO+IDOsXkQb8AGHRqoys56+6TJlKUI6NOHmti3LcnK2TZMOMZFPN9KYlL85MbVm4lR9c4NMwfSJWEkvWNZVgSoAzskc5Vg9qAFjeiFVRkVOm+lvftQpcrDethlHDWdU5knWIxlqelvumsh3TeoNjsDz20qzNUodn9N8/5wNdXnqUjzt9Grt7RWB52APjeVk/aGw3eeE19xs3Pu8/YG93OaWKKX76YPry6ap1cTzccMttuWUR+c2kAfKPGRtlDR4mhJP5agNK/8tK8QAj344xeBl7G/vin+/Xyx8nrwg3I/vu1QUv/+SuAVOdi8699T2LnAqtHLiHDxgjH/kYBi3PVfGIhh+79AIE0k2aTeDhNUI5YNeoHHdgRPYehse+xDd2fIixEa8MLF6Vli0NGdmKrRZfRQIQpWcFAhJWLjuXplf+9Lz7fxBf/dwavGWWkuYSABUvgkdK0niSzCibrG3A2mykOCmVNUl9uFDD/9f3WWzTaYMNs9rT1q5V4OKjwUtx56nAVetzzjSqNOfbUs8yDDfPQohTxcVnDZTX396qy0+z59UCRLWBgqPH9ZD9R6MHtA47zIrI0CeXcSTmrQbcQw+o1N9JWR2b93KacNNlw/HDSE7jM7hrbxQ+3WOizL576sVEj90ug28+xOSScwbJGRd9lM1XJEJHAf9z7eiOX4GYwVlbQ4oCUDOPl35u4ZTAy9uHwZ/c5HRdcOYAeeHVjbLRr6I4GZZlTVNTcUyguT4P2aOd6eS1ku4y8rPvdJZFn8Rl+dqkfGNkTI47ICr9e+DnPHgzjPe+/KUIX1sk3x+fN+iHiwR1u83xpq+hsWlxYvnLK/GueAKrD6lISVEqWhRL1dZhHZTv1GKBUirxebNlvdJS0wvH/WFQy6dipq8tylENJf6P1kzlmcaGpucUOb4TyGcNNsMLU6fD9jyPmRwdhu9kPX3LSFxqu+lbWizhgv5vzxgo1138Fd/p1vluULBH25TkDoOLqKQ/rMDRkcFif0QWY512Id4CY2KUYtm4/SuxdZdJJ/TTl25YxmWvND/7E0rUT/+4nMU6QWrDf540ZgfnvNY/9JV8brJ+yM3NP1LQhTLNb66mXITXH3MTfTA/jOZKuCMrc/JOJ20U2QlTt9t/012evbxSfjMR/5FJnyKc7KXYiqSsvFQ3ftuhrLwMP/cv0e888DiX53Gx1NU2voiv5tQ3JqKNDclEQ31aGvDpJPfrhZ7F7lOh+t7BSCx38QasCpsOaiGj28wzjygEvgrbdIC5PPb6638YOGbMHh9gANz1gl7qWesG2M5qX1FbN2UcMvL5Q0dZJisjbcAnJ8vxFpflaTkOQs0FvOtwSuQmq0vK1G77Hoz0QeWhuC1/1O+QQQRlW/Ltth+yUdvHznzgMc0KNRfwzCuUrK7zZvv855O/BD73xC+fx/FlIX7yiXoYZYuwWcTVm2ucpfQ97X/lYE8NvYGpp56dttePf3FdtZSsS0p5D7zVhcgqS2A1/5NpBsUq88BoIXe2Kc98pTB5bIcAuPx0eXVsy9apk4uLi37Mws+SbJBbA0p7uj9r/fb07+jyz2r/Z63fln8KRIBXP7kPQBKMbE8/MMJ3bIEI+92gs8NpYz1L5JuaE3f23umAs4AdRNMaAHUEpgI5ryJmK1jFz0DzpgoMVr2w8Swpzcyd8/4fYGx2EvopGzInSQttVGsyhZqw3/mThvlCsk6XK2HfWv8aba3Ojsw33wr5Hi5rzYawz2G+NXnzdVv8N5AWFcWwgoFpQnERaAzRFl9Ax5zdfRWHQHYPLNwXczyw+QgZG+rWzp09/zIRfP9f/xPpBQStTQMwCq1efFtzod38cMSlMI6rsLnpgsi62PLlzx7du0/l/ejgAOTsbHf20SYmqiHv1OVf6ijRVsrXZ7pJCyVrqXDrhWrk5m1ve7m13UlmNrqyf3//eULk93f+sfVDuP8gk16zbssPhg4a/zT+32wAlv8D+iEArU4LbIis6udG85HBY2wTsbmfqUufktjqeQ/8vFvXzlcCrx68bUMnH7hhR53lbMZ0MMd456eBwjouv3575a6N7L6lPJyECRaZ8tvP1jSubXvbO3Hz7c+Xz2+/pb25gaK9crPaaEv5z8d/9GF6y9atv+2350mTZW0cgK3FxvlsMEVwA2qGfI40iKJeJxvCxok0P76AyfXa2nS/Pb8/edWaTSfislDrgiDukDmWGmHDg+qqc6CohtTxdpdN2Wxd6nB6spRaXR1HyYc7Psxn9WfrsL6zy2i27UAe7Wobzhyt4S8Wjg8OWrM364Nri/5SNus3+aA9lGl7KpOt++/sP7FATDjQ6m/CAFhihtjxHeF7c0cQPDdpkTAC05E5FnQJNry8Ur9VrnvgmY9G7z7k/gH9e3XFDdseGIgQ6G3QSLEpGj1VHr4YbdHc9mewZ5iMAgrKk2YBRN4kKL0jk7Xl2/8S+4/AkWpqbr77helzTj5wwrlvMbCJVGKrRmcPwDb5C+l09nSh5EfApgz4jJ9sjkoffKsnHY88ctvvB+y/z57fruhUdgQ+QDwEE/e+CCkVZnF4GAsp39486jWdrOuAikisuczJlcg9ytY1Z3lBILb0wkB9nle8UV3QWlAjlKcCObv22ssR/hQHLfXzRP1i/AdQ6/CB6DX4SvrSuoam59+YO+8fx596SbV+EikA7ToA94uZIlj32cjYcZiyDJuBdyj4GgC4FgDuidlNHL2Hj+2mk8j3r/LxuCN9eXogYp/23Ig1MXy/i8f8htfaDTiXugCs4XXaHT+vDXdsW0CzMlCCl//jCd+yYPTlf93DT5sDvASxJYK5I315ekA/NOfdUbDyw3P8okw5NkZZvQ8CH4CWwjje8WlbgEYZbFUgC0ANwIzAdSxDIpA70pe3BwhUJs4GucZvgOWNWBULWM7tC0vbCjiTA62CcQZg2sko3JG+/D1AsDLxAVUOYJn5hYKWDW4v6MLyHsRUQyB3pC9vDxCoTFXchUEa5ln2haVPC7hPW+8Lc6yjoR3aA/8ywO5QrzqUd/RARw909EBHDxTogf8HYEluyH3HnLUAAAAASUVORK5CYII=" alt="">
                              </a>
                            </div>
                              <div class="left-adv-link">
                                <img class="left-adv-img"src="https://i.pinimg.com/originals/69/c6/ae/69c6ae93eeca75511e37778ef17d95b1.jpg" alt="">
                              </div> 
                                 <div class="right-adv-link">
                                 <img class="right-adv-img"src="https://i.pinimg.com/736x/d7/7b/27/d77b277061f15a1d93babb92c3734ec8--shoe-banner-design-banner-shoes.jpg" alt="">
                             </div>
                            </ol>
                           
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>

                    <div class="col-sm-9">
                        <div id="content" class="row">
                        <c:forEach items="${listP}" var="p">
                            <div class="product col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${p.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${p.pid}" title="View Product">${p.name}</a></h4>
                                        <p class="card-text show_txt">${p.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${p.price} $</p>
                                            </div>
                                            <div class="col">
                                                <a href="order?pcid=${p.pid}" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <button  style="margin-top: 20px; margin-left: 370px;" onclick="loadMore()" class="btn btn-primary">Load more</button>
                </div>

            </div>
        </div>

        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                        function loadMore() {
                            var amount = document.getElementsByClassName("product").length;
                            $.ajax({
                                url: "/Shop-project/load",
                                type: "get", //send it through get method
                                data: {
                                    exits: amount
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML += data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
                        function searchByName(param){
                            var txtSearch = param.value;
                            $.ajax({
                                url: "/Shop-project/searchAjax",
                                type: "get", //send it through get method
                                data: {
                                    txt: txtSearch
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML = data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
                        function load(cateid) {
                             $.ajax({
                                url: "/Shop-project/category",
                                type: "get", //send it through get method
                                data: {
                                   cid: cateid
                                },
                                success: function (responseData) {
                                   document.getElementById("content").innerHTML
                                   = responseData;
                                }
                            });
                        }

        </script>  
    </body>
</html>

