(function(){var a=0,b=[],c=0,b=document.getElementsByTagName("link");if(0<b.length){for(a=0;a<b.length;a++)"undefined"!==typeof b[a].rel&&-1<b[a].rel.indexOf("shortcut icon")&&(c=1,window.location.href=b[a].href);0===c&&alert("favico Not Found")}else alert("favico Not Found")})();