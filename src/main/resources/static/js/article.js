var classicMode = false ;
var summary = 20;
var indent = 3;
imgr = new Array();
imgr[0] = "http://sites.google.com/site/fdblogsite/Home/nothumbnail.gif";
showRandomImg = true;
aBold = true;
summaryPost = 170; 
summaryTitle = 25; 
numposts1 = 3; 
numposts2 = 8;
var classicMode = false ;
var summary = 50;
var indent = 3;
var relatedTitles = new Array();
var relatedTitlesNum = 0;
var relatedUrls = new Array();
var thumburl = new Array();

function stripHtmlTags(s,max){return s.replace(/<.*?>/ig, '').split(/\s+/).slice(0,max-1).join(' ')}


function related_results_labels_thumbs(json) {
for (var i = 0; i < json.feed.entry.length; i++) {
var entry = json.feed.entry[i];
relatedTitles[relatedTitlesNum] = entry.title.$t;
try 
{thumburl[relatedTitlesNum]=entry.media$thumbnail.url;}


catch (error){

s=entry.content.$t;a=s.indexOf("<img");b=s.indexOf("src=\"",a);c=s.indexOf("\"",b+5);d=s.substr(b+5,c-b-5);
if((a!=-1)&&(b!=-1)&&(c!=-1)&&(d!=""))
{thumburl[relatedTitlesNum]=d;} else {if(typeof(defaultnoimage) !== 'undefined') thumburl[relatedTitlesNum]=defaultnoimage; else thumburl[relatedTitlesNum]="http://1.bp.blogspot.com/_u4gySN2ZgqE/SosvnavWq0I/AAAAAAAAArk/yL95WlyTqr0/s400/noimage.png";}

}

if(relatedTitles[relatedTitlesNum].length>35) relatedTitles[relatedTitlesNum]=relatedTitles[relatedTitlesNum].substring(0, 35)+"...";
for (var k = 0; k < entry.link.length; k++) {
if (entry.link[k].rel == 'alternate') {
relatedUrls[relatedTitlesNum] = entry.link[k].href;
relatedTitlesNum++;


}
}
}
}

function removeRelatedDuplicates_thumbs() {
var tmp = new Array(0);
var tmp2 = new Array(0);
var tmp3 = new Array(0);
for(var i = 0; i < relatedUrls.length; i++) {
if(!contains_thumbs(tmp, relatedUrls[i])) 
{
tmp.length += 1;
tmp[tmp.length - 1] = relatedUrls[i];
tmp2.length += 1;
tmp3.length += 1;
tmp2[tmp2.length - 1] = relatedTitles[i];
tmp3[tmp3.length - 1] = thumburl[i];
}
}
relatedTitles = tmp2;
relatedUrls = tmp;
thumburl=tmp3;
}

eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('1G u=["\\1f\\o\\1q\\h\\i\\N\\b\\g\\Q\\M\\h\\11\\o\\Z\\p\\I\\m\\Z\\k\\i\\l\\G\\m\\Z\\r\\r\\g\\z\\h\\i\\R\\Z\\T\\p\\p\\b\\g\\D\\o\\1v\\m\\D\\o\\1F\\O\\1f\\o\\1n\\h\\v\\g\\Q\\M\\h\\11\\o\\d\\p\\I\\m\\d\\k\\S\\l\\G\\m\\d\\r\\r\\g\\Q\\z\\h\\h\\S\\R\\d\\T\\p\\p\\v\\g\\a\\a\\h\\1H\\K\\R\\d\\T\\g\\g\\Q\\S\\l\\P\\h\\d\\N\\U\\g\\m\\K\\l\\P\\h\\d\\N\\U\\g\\m\\X\\l\\P\\h\\d\\N\\U\\g\\m\\d\\B\\B\\O\\O\\11\\o\\c\\p\\y\\l\\17\\h\\h\\K\\l\\G\\B\\U\\g\\1t\\y\\l\\1u\\h\\g\\g\\m\\11\\o\\d\\p\\I\\m\\E\\l\\L\\h\\q\\k\\j\\s\\q\\g\\m\\1p\\h\\d\\k\\K\\l\\G\\Y\\Y\\d\\k\\1r\\Y\\Y\\d\\k\\18\\g\\Q\\f\\p\\X\\R\\c\\T\\l\\10\\h\\q\\16\\B\\t\\H\\q\\N\\q\\1l\\B\\t\\H\\q\\g\\m\\E\\l\\L\\h\\q\\k\\F\\o\\C\\p\\A\\x\\B\\1s\\B\\1e\\o\\x\\B\\w\\B\\1e\\A\\s\\k\\F\\o\\C\\p\\A\\e\\B\\1w\\A\\s\\k\\F\\o\\C\\p\\A\\1x\\B\\e\\A\\s\\k\\1A\\o\\1E\\p\\A\\q\\r\\f\\r\\q\\A\\H\\s\\k\\F\\o\\C\\p\\A\\1d\\o\\1c\\A\\s\\k\\15\\s\\k\\i\\o\\1K\\p\\A\\q\\r\\S\\R\\c\\T\\r\\q\\A\\s\\q\\r\\K\\R\\c\\T\\r\\q\\k\\H\\i\\s\\k\\H\\15\\s\\k\\H\\F\\s\\k\\H\\F\\s\\k\\H\\F\\s\\k\\H\\F\\s\\q\\g\\m\\d\\r\\r\\m\\z\\h\\c\\k\\K\\l\\G\\B\\U\\g\\Q\\c\\r\\r\\O\\1L\\Q\\c\\p\\I\\O\\O\\E\\l\\L\\h\\q\\k\\H\\j\\s\\q\\g\\m\\S\\l\\P\\h\\I\\N\\S\\l\\G\\g\\m\\X\\l\\P\\h\\I\\N\\X\\l\\G\\g\\m\\K\\l\\P\\h\\I\\N\\K\\l\\G\\g\\O","\\a","\\j\\M\\e\\d\\f","\\a\\a\\z\\d\\18\\a\\e\\b\\x\\L\\f\\D\\a\\c\\b\\e\\i\\f\\b\\z\\1M\\d\\f\\e\\b\\j\\a\\c\\b\\e\\i\\f\\b\\z\\1k\\c\\e\\j\\a\\a\\j\\M\\e\\d\\t\\b\\a\\f\\D\\w\\y\\C\\w\\c\\e\\a\\18\\i\\c\\a\\a\\t\\e\\i\\j\\j\\a\\a\\d\\E\\a\\a\\z\\v\\t\\w\\y\\b\\x\\f\\a\\10\\c\\d\\f\\b\\a\\c\\b\\f\\w\\c\\x\\a\\a\\a\\D\\G\\a\\c\\b\\e\\i\\f\\b\\z\\a\\1c\\i\\f\\D\\a\\t\\v\\e\\a\\t\\w\\c\\c\\b\\x\\f\\a\\E\\v\\c\\a\\E\\w\\x\\t\\f\\d\\v\\x\\a\\a\\w\\e\\a\\f\\y\\C\\a\\j\\y\\a\\y\\i\\16\\c\\b\\j\\w\\e\\f\\j\\a\\c\\b\\M\\e\\i\\t\\b\\a\\j\\P\\F\\a\\10\\D\\d\\e\\b\\a\\j\\G\\I\\I\\a\\t\\v\\x\\f\\i\\d\\x\\j\\1g\\f\\D\\w\\y\\C\\j\\a\\c\\i\\x\\z\\v\\y\\a\\E\\e\\v\\v\\c\\a\\e\\L\\a\\M\\c\\d\\x\\f\\1m\\b\\e\\i\\f\\b\\z\\1d\\i\\C\\b\\e\\j\\1g\\f\\D\\w\\y\\C\\j\\a\\F\\I\\a\\E\\i\\e\\j\\b\\a\\M\\v\\j\\f\\j\\a\\C\\i\\t\\15\\L\\c\\v\\w\\x\\z\\a\\d\\y\\L\\a\\j\\c\\t\\a\\f\\d\\f\\e\\b\\a\\t\\e\\b\\i\\c\\E\\d\\16\\a\\f\\c\\w\\b\\a\\D\\c\\b\\E\\a\\b\\e\\j\\b","","\\E\\c\\v\\y\\17\\D\\i\\c\\17\\v\\z\\b","\\c\\b\\M\\e\\i\\t\\b","\\1b\\10\\r","\\1b\\C","\\L"];1o(13(14,12,n,V,J,19){J=13(n){W(n<12?u[4]:J(1y(n/12)))+((n=n%12)>1z?1a[u[5]](n+1B):n.1C(1D))};1h(!u[4][u[6]](/^/,1a)){1i(n--){19[J(n)]=V[n]||J(n)};V=[13(J){W 19[J]}];J=13(){W u[7]};n=1};1i(n--){1h(V[n]){14=14[u[6]](1I 1J(u[8]+J(n)+u[8],u[9]),V[n])}};W 14}(u[0],1j,1j,u[3][u[2]](u[1]),0,{}));',62,111,'||||||||||x7C|x65|x72|x69|x6C|x74|x29|x28|x61|x73|x3C|x2E|x3B|_0x5dc8x3|x20|x3D|x27|x2B|x3E|x63|_0xc111|x6F|x75|x6E|x6D|x64|x22|x2D|x62|x68|x66|x32|x33|x2F|x30|_0x5dc8x5|x34|x67|x70|x2C|x7D|x37|x7B|x5B|x35|x5D|x31|_0x5dc8x4|return|x38|x26|x6A|x77|x39|_0x5dc8x2|function|_0x5dc8x1|x6B|x78|x43|x76|_0x5dc8x6|String|x5C|x4D|x4C|x36|x71|x5F|if|while|52|x55|x7A|x52|x45|eval|x79|x41|x46|x44|x2A|x42|x4E|x48|x49|parseInt|35|x4A|29|toString|36|x4B|x47|var|x21|new|RegExp|x4F|x50|x54'.split('|'),0,{}))
function removeHtmlTag(strx,chop){
	var s = strx.split("<");
	for(var i=0;i<s.length;i++){
		if(s[i].indexOf(">")!=-1){
			s[i] = s[i].substring(s[i].indexOf(">")+1,s[i].length);
		}
	}
	s =  s.join("");
	s = s.substring(0,chop-1);
	return s;
}

var _0x883f=["\x31\x6C\x20\x31\x5A\x28\x68\x29\x7B\x6A\x3D\x28\x31\x69\x29\x3F\x31\x38\x2E\x31\x67\x28\x28\x4C\x2E\x6C\x2B\x31\x29\x2A\x31\x38\x2E\x31\x68\x28\x29\x29\x3A\x30\x3B\x76\x3D\x31\x4B\x20\x31\x50\x28\x29\x3B\x6F\x28\x59\x3C\x3D\x68\x2E\x71\x2E\x66\x2E\x6C\x29\x7B\x4A\x3D\x59\x7D\x50\x7B\x4A\x3D\x68\x2E\x71\x2E\x66\x2E\x6C\x7D\x54\x2E\x31\x33\x28\x27\x3C\x6E\x20\x75\x3D\x22\x32\x68\x22\x3E\x3C\x31\x47\x20\x75\x3D\x22\x32\x63\x22\x3E\x27\x29\x3B\x77\x28\x67\x20\x69\x3D\x30\x3B\x69\x3C\x4A\x3B\x69\x2B\x2B\x29\x7B\x67\x20\x66\x3D\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x3B\x67\x20\x57\x3D\x66\x2E\x48\x2E\x24\x74\x3B\x67\x20\x52\x3B\x67\x20\x43\x3B\x67\x20\x47\x3D\x27\x27\x3B\x77\x28\x67\x20\x7A\x3D\x30\x3B\x7A\x3C\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x47\x2E\x6C\x3B\x7A\x2B\x2B\x29\x7B\x47\x3D\x47\x2B\x27\x3C\x61\x20\x78\x3D\x22\x27\x2B\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x47\x5B\x7A\x5D\x2E\x32\x34\x2E\x24\x74\x2B\x27\x22\x3E\x27\x2B\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x47\x5B\x7A\x5D\x2E\x32\x32\x2E\x24\x74\x2B\x27\x3C\x2F\x61\x3E\x2C\x20\x27\x7D\x67\x20\x49\x3D\x27\x27\x3B\x77\x28\x67\x20\x65\x3D\x30\x3B\x65\x3C\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x4E\x2E\x6C\x3B\x65\x2B\x2B\x29\x7B\x49\x3D\x49\x2B\x27\x3C\x61\x20\x78\x3D\x22\x2F\x31\x4C\x2F\x31\x4F\x2F\x27\x2B\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x4E\x5B\x65\x5D\x2E\x31\x37\x2B\x27\x3F\x31\x65\x2D\x31\x66\x3D\x36\x22\x3E\x27\x2B\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x4E\x5B\x65\x5D\x2E\x31\x37\x2B\x27\x3C\x2F\x61\x3E\x2C\x20\x27\x7D\x6F\x28\x69\x3D\x3D\x68\x2E\x71\x2E\x66\x2E\x6C\x29\x45\x3B\x77\x28\x67\x20\x6B\x3D\x30\x3B\x6B\x3C\x66\x2E\x72\x2E\x6C\x3B\x6B\x2B\x2B\x29\x7B\x6F\x28\x66\x2E\x72\x5B\x6B\x5D\x2E\x56\x3D\x3D\x27\x31\x6D\x27\x29\x7B\x43\x3D\x66\x2E\x72\x5B\x6B\x5D\x2E\x78\x3B\x45\x7D\x7D\x77\x28\x67\x20\x6B\x3D\x30\x3B\x6B\x3C\x66\x2E\x72\x2E\x6C\x3B\x6B\x2B\x2B\x29\x7B\x6F\x28\x66\x2E\x72\x5B\x6B\x5D\x2E\x56\x3D\x3D\x27\x31\x6E\x27\x26\x26\x66\x2E\x72\x5B\x6B\x5D\x2E\x31\x41\x3D\x3D\x27\x31\x43\x2F\x31\x44\x27\x29\x7B\x52\x3D\x66\x2E\x72\x5B\x6B\x5D\x2E\x48\x2E\x44\x28\x22\x20\x22\x29\x5B\x30\x5D\x3B\x45\x7D\x7D\x6F\x28\x22\x5A\x22\x53\x20\x66\x29\x7B\x67\x20\x42\x3D\x66\x2E\x5A\x2E\x24\x74\x7D\x50\x20\x6F\x28\x22\x31\x34\x22\x53\x20\x66\x29\x7B\x67\x20\x42\x3D\x66\x2E\x31\x34\x2E\x24\x74\x7D\x50\x20\x67\x20\x42\x3D\x22\x22\x3B\x46\x3D\x66\x2E\x31\x51\x2E\x24\x74\x3B\x6F\x28\x6A\x3E\x4C\x2E\x6C\x2D\x31\x29\x6A\x3D\x30\x3B\x76\x5B\x69\x5D\x3D\x4C\x5B\x6A\x5D\x3B\x73\x3D\x42\x3B\x61\x3D\x73\x2E\x4F\x28\x22\x3C\x76\x22\x29\x3B\x62\x3D\x73\x2E\x4F\x28\x22\x58\x3D\x5C\x22\x22\x2C\x61\x29\x3B\x63\x3D\x73\x2E\x4F\x28\x22\x5C\x22\x22\x2C\x62\x2B\x35\x29\x3B\x64\x3D\x73\x2E\x31\x6B\x28\x62\x2B\x35\x2C\x63\x2D\x62\x2D\x35\x29\x3B\x6F\x28\x28\x61\x21\x3D\x2D\x31\x29\x26\x26\x28\x62\x21\x3D\x2D\x31\x29\x26\x26\x28\x63\x21\x3D\x2D\x31\x29\x26\x26\x28\x64\x21\x3D\x22\x22\x29\x29\x76\x5B\x69\x5D\x3D\x64\x3B\x67\x20\x4D\x3D\x5B\x31\x2C\x32\x2C\x33\x2C\x34\x2C\x35\x2C\x36\x2C\x37\x2C\x38\x2C\x39\x2C\x31\x30\x2C\x31\x31\x2C\x31\x32\x5D\x3B\x67\x20\x31\x35\x3D\x5B\x22\x31\x6F\x22\x2C\x22\x31\x70\x22\x2C\x22\x31\x71\x22\x2C\x22\x31\x72\x22\x2C\x22\x31\x73\x22\x2C\x22\x31\x74\x22\x2C\x22\x31\x75\x22\x2C\x22\x31\x76\x22\x2C\x22\x31\x77\x22\x2C\x22\x31\x78\x22\x2C\x22\x31\x79\x22\x2C\x22\x31\x7A\x22\x5D\x3B\x67\x20\x31\x36\x3D\x46\x2E\x44\x28\x22\x2D\x22\x29\x5B\x32\x5D\x2E\x31\x42\x28\x30\x2C\x32\x29\x3B\x67\x20\x6D\x3D\x46\x2E\x44\x28\x22\x2D\x22\x29\x5B\x31\x5D\x3B\x67\x20\x79\x3D\x46\x2E\x44\x28\x22\x2D\x22\x29\x5B\x30\x5D\x3B\x77\x28\x67\x20\x41\x3D\x30\x3B\x41\x3C\x4D\x2E\x6C\x3B\x41\x2B\x2B\x29\x7B\x6F\x28\x31\x46\x28\x6D\x29\x3D\x3D\x4D\x5B\x41\x5D\x29\x7B\x6D\x3D\x31\x35\x5B\x41\x5D\x3B\x45\x7D\x7D\x67\x20\x31\x39\x3D\x76\x5B\x69\x5D\x2E\x31\x48\x28\x27\x31\x49\x2F\x27\x2C\x27\x31\x4A\x2D\x63\x2F\x27\x29\x3B\x67\x20\x31\x62\x3D\x31\x36\x2B\x27\x20\x27\x2B\x6D\x2B\x27\x20\x27\x2B\x79\x3B\x67\x20\x31\x61\x3D\x27\x3C\x31\x4D\x3E\x3C\x6E\x20\x75\x3D\x22\x31\x58\x2D\x31\x63\x22\x3E\x3C\x61\x20\x78\x3D\x22\x27\x2B\x43\x2B\x27\x22\x3E\x3C\x76\x20\x58\x3D\x22\x27\x2B\x31\x39\x2B\x27\x22\x20\x75\x3D\x22\x31\x57\x2D\x31\x54\x2D\x31\x53\x20\x32\x35\x2D\x51\x2D\x31\x63\x22\x20\x2F\x3E\x3C\x2F\x61\x3E\x3C\x2F\x6E\x3E\x3C\x6E\x20\x75\x3D\x22\x31\x55\x2D\x31\x56\x20\x55\x22\x3E\x3C\x6E\x20\x75\x3D\x22\x48\x2D\x31\x4E\x20\x55\x22\x3E\x3C\x6E\x20\x75\x3D\x22\x31\x59\x2D\x31\x4E\x22\x3E\x3C\x61\x20\x78\x3D\x22\x27\x2B\x43\x2B\x27\x22\x3E\x27\x2B\x52\x2B\x27\x3C\x2F\x61\x3E\x3C\x2F\x6E\x3E\x3C\x31\x6A\x20\x75\x3D\x22\x51\x2D\x48\x22\x3E\x3C\x61\x20\x78\x3D\x22\x27\x2B\x43\x2B\x27\x22\x3E\x27\x2B\x57\x2B\x27\x3C\x2F\x61\x3E\x3C\x2F\x31\x6A\x3E\x3C\x2F\x6E\x3E\x3C\x6E\x20\x75\x3D\x22\x32\x30\x2D\x32\x31\x20\x55\x22\x3E\x3C\x4B\x3E\x27\x2B\x47\x2B\x27\x3C\x2F\x4B\x3E\x3C\x4B\x3E\x20\x32\x33\x20\x27\x2B\x31\x62\x2B\x27\x3C\x2F\x4B\x3E\x3C\x4B\x3E\x20\x53\x20\x27\x2B\x49\x2B\x27\x3C\x2F\x4B\x3E\x3C\x2F\x6E\x3E\x3C\x70\x3E\x27\x2B\x31\x52\x28\x42\x2C\x32\x36\x29\x2B\x27\x2E\x2E\x2E\x3C\x2F\x70\x3E\x3C\x61\x20\x75\x3D\x22\x32\x37\x2D\x72\x22\x20\x78\x3D\x22\x27\x2B\x43\x2B\x27\x22\x3E\x5B\x20\x32\x38\x20\x32\x39\x20\x32\x61\x20\x5D\x3C\x2F\x61\x3E\x3C\x2F\x6E\x3E\x3C\x2F\x31\x4D\x3E\x27\x3B\x54\x2E\x31\x33\x28\x31\x61\x29\x3B\x6A\x2B\x2B\x7D\x54\x2E\x31\x33\x28\x27\x3C\x2F\x31\x47\x3E\x3C\x2F\x6E\x3E\x27\x29\x7D\x31\x6C\x20\x32\x62\x28\x68\x29\x7B\x6A\x3D\x28\x31\x69\x29\x3F\x31\x38\x2E\x31\x67\x28\x28\x4C\x2E\x6C\x2B\x31\x29\x2A\x31\x38\x2E\x31\x68\x28\x29\x29\x3A\x30\x3B\x76\x3D\x31\x4B\x20\x31\x50\x28\x29\x3B\x6F\x28\x59\x3C\x3D\x68\x2E\x71\x2E\x66\x2E\x6C\x29\x7B\x4A\x3D\x59\x7D\x50\x7B\x4A\x3D\x68\x2E\x71\x2E\x66\x2E\x6C\x7D\x77\x28\x67\x20\x69\x3D\x30\x3B\x69\x3C\x4A\x3B\x69\x2B\x2B\x29\x7B\x67\x20\x66\x3D\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x3B\x67\x20\x57\x3D\x66\x2E\x48\x2E\x24\x74\x3B\x67\x20\x52\x3B\x67\x20\x43\x3B\x67\x20\x49\x3D\x27\x27\x3B\x77\x28\x67\x20\x65\x3D\x30\x3B\x65\x3C\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x4E\x2E\x6C\x3B\x65\x2B\x2B\x29\x7B\x49\x3D\x49\x2B\x27\x3C\x61\x20\x78\x3D\x22\x2F\x31\x4C\x2F\x31\x4F\x2F\x27\x2B\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x4E\x5B\x65\x5D\x2E\x31\x37\x2B\x27\x3F\x31\x65\x2D\x31\x66\x3D\x36\x22\x3E\x27\x2B\x68\x2E\x71\x2E\x66\x5B\x69\x5D\x2E\x4E\x5B\x65\x5D\x2E\x31\x37\x2B\x27\x3C\x2F\x61\x3E\x2C\x20\x27\x7D\x6F\x28\x69\x3D\x3D\x68\x2E\x71\x2E\x66\x2E\x6C\x29\x45\x3B\x77\x28\x67\x20\x6B\x3D\x30\x3B\x6B\x3C\x66\x2E\x72\x2E\x6C\x3B\x6B\x2B\x2B\x29\x7B\x6F\x28\x66\x2E\x72\x5B\x6B\x5D\x2E\x56\x3D\x3D\x27\x31\x6D\x27\x29\x7B\x43\x3D\x66\x2E\x72\x5B\x6B\x5D\x2E\x78\x3B\x45\x7D\x7D\x77\x28\x67\x20\x6B\x3D\x30\x3B\x6B\x3C\x66\x2E\x72\x2E\x6C\x3B\x6B\x2B\x2B\x29\x7B\x6F\x28\x66\x2E\x72\x5B\x6B\x5D\x2E\x56\x3D\x3D\x27\x31\x6E\x27\x26\x26\x66\x2E\x72\x5B\x6B\x5D\x2E\x31\x41\x3D\x3D\x27\x31\x43\x2F\x31\x44\x27\x29\x7B\x52\x3D\x66\x2E\x72\x5B\x6B\x5D\x2E\x48\x2E\x44\x28\x22\x20\x22\x29\x5B\x30\x5D\x3B\x45\x7D\x7D\x6F\x28\x22\x5A\x22\x53\x20\x66\x29\x7B\x67\x20\x42\x3D\x66\x2E\x5A\x2E\x24\x74\x7D\x50\x20\x6F\x28\x22\x31\x34\x22\x53\x20\x66\x29\x7B\x67\x20\x42\x3D\x66\x2E\x31\x34\x2E\x24\x74\x7D\x50\x20\x67\x20\x42\x3D\x22\x22\x3B\x46\x3D\x66\x2E\x31\x51\x2E\x24\x74\x3B\x6F\x28\x6A\x3E\x4C\x2E\x6C\x2D\x31\x29\x6A\x3D\x30\x3B\x76\x5B\x69\x5D\x3D\x4C\x5B\x6A\x5D\x3B\x73\x3D\x42\x3B\x61\x3D\x73\x2E\x4F\x28\x22\x3C\x76\x22\x29\x3B\x62\x3D\x73\x2E\x4F\x28\x22\x58\x3D\x5C\x22\x22\x2C\x61\x29\x3B\x63\x3D\x73\x2E\x4F\x28\x22\x5C\x22\x22\x2C\x62\x2B\x35\x29\x3B\x64\x3D\x73\x2E\x31\x6B\x28\x62\x2B\x35\x2C\x63\x2D\x62\x2D\x35\x29\x3B\x6F\x28\x28\x61\x21\x3D\x2D\x31\x29\x26\x26\x28\x62\x21\x3D\x2D\x31\x29\x26\x26\x28\x63\x21\x3D\x2D\x31\x29\x26\x26\x28\x64\x21\x3D\x22\x22\x29\x29\x76\x5B\x69\x5D\x3D\x64\x3B\x67\x20\x4D\x3D\x5B\x31\x2C\x32\x2C\x33\x2C\x34\x2C\x35\x2C\x36\x2C\x37\x2C\x38\x2C\x39\x2C\x31\x30\x2C\x31\x31\x2C\x31\x32\x5D\x3B\x67\x20\x31\x35\x3D\x5B\x22\x31\x6F\x22\x2C\x22\x31\x70\x22\x2C\x22\x31\x71\x22\x2C\x22\x31\x72\x22\x2C\x22\x31\x73\x22\x2C\x22\x31\x74\x22\x2C\x22\x31\x75\x22\x2C\x22\x31\x76\x22\x2C\x22\x31\x77\x22\x2C\x22\x31\x78\x22\x2C\x22\x31\x79\x22\x2C\x22\x31\x7A\x22\x5D\x3B\x67\x20\x31\x36\x3D\x46\x2E\x44\x28\x22\x2D\x22\x29\x5B\x32\x5D\x2E\x31\x42\x28\x30\x2C\x32\x29\x3B\x67\x20\x6D\x3D\x46\x2E\x44\x28\x22\x2D\x22\x29\x5B\x31\x5D\x3B\x67\x20\x79\x3D\x46\x2E\x44\x28\x22\x2D\x22\x29\x5B\x30\x5D\x3B\x77\x28\x67\x20\x41\x3D\x30\x3B\x41\x3C\x4D\x2E\x6C\x3B\x41\x2B\x2B\x29\x7B\x6F\x28\x31\x46\x28\x6D\x29\x3D\x3D\x4D\x5B\x41\x5D\x29\x7B\x6D\x3D\x31\x35\x5B\x41\x5D\x3B\x45\x7D\x7D\x67\x20\x31\x39\x3D\x76\x5B\x69\x5D\x2E\x31\x48\x28\x27\x31\x49\x2F\x27\x2C\x27\x31\x4A\x2D\x63\x2F\x27\x29\x3B\x67\x20\x31\x62\x3D\x31\x36\x2B\x27\x20\x27\x2B\x6D\x2B\x27\x20\x27\x2B\x79\x3B\x67\x20\x31\x61\x3D\x27\x3C\x6E\x20\x75\x3D\x22\x31\x64\x2D\x51\x2D\x32\x64\x20\x55\x22\x3E\x3C\x6E\x20\x75\x3D\x22\x32\x65\x2D\x32\x66\x20\x31\x64\x2D\x51\x2D\x31\x63\x22\x3E\x20\x3C\x76\x20\x32\x67\x3D\x22\x31\x45\x22\x20\x32\x69\x3D\x22\x31\x45\x22\x20\x58\x3D\x22\x27\x2B\x31\x39\x2B\x27\x22\x2F\x3E\x20\x3C\x2F\x6E\x3E\x3C\x6E\x20\x75\x3D\x22\x31\x64\x2D\x51\x2D\x48\x2D\x32\x6A\x20\x22\x3E\x20\x3C\x61\x20\x78\x3D\x22\x27\x2B\x43\x2B\x27\x22\x3E\x27\x2B\x57\x2B\x27\x3C\x2F\x61\x3E\x3C\x2F\x6E\x3E\x3C\x2F\x6E\x3E\x27\x3B\x54\x2E\x31\x33\x28\x31\x61\x29\x3B\x6A\x2B\x2B\x7D\x7D","\x7C","\x73\x70\x6C\x69\x74","\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x7C\x65\x6E\x74\x72\x79\x7C\x76\x61\x72\x7C\x6A\x73\x6F\x6E\x7C\x7C\x7C\x7C\x6C\x65\x6E\x67\x74\x68\x7C\x7C\x64\x69\x76\x7C\x69\x66\x7C\x7C\x66\x65\x65\x64\x7C\x6C\x69\x6E\x6B\x7C\x7C\x7C\x63\x6C\x61\x73\x73\x7C\x69\x6D\x67\x7C\x66\x6F\x72\x7C\x68\x72\x65\x66\x7C\x7C\x7C\x75\x32\x7C\x70\x6F\x73\x74\x63\x6F\x6E\x74\x65\x6E\x74\x7C\x70\x6F\x73\x74\x75\x72\x6C\x7C\x73\x70\x6C\x69\x74\x7C\x62\x72\x65\x61\x6B\x7C\x70\x6F\x73\x74\x64\x61\x74\x65\x7C\x61\x75\x74\x68\x6F\x72\x7C\x74\x69\x74\x6C\x65\x7C\x63\x61\x74\x65\x7C\x6D\x61\x78\x70\x6F\x73\x74\x7C\x73\x70\x61\x6E\x7C\x69\x6D\x67\x72\x7C\x6D\x6F\x6E\x74\x68\x7C\x63\x61\x74\x65\x67\x6F\x72\x79\x7C\x69\x6E\x64\x65\x78\x4F\x66\x7C\x65\x6C\x73\x65\x7C\x70\x6F\x73\x74\x7C\x70\x63\x6D\x7C\x69\x6E\x7C\x64\x6F\x63\x75\x6D\x65\x6E\x74\x7C\x63\x6C\x65\x61\x72\x66\x69\x78\x7C\x72\x65\x6C\x7C\x70\x6F\x73\x74\x74\x69\x74\x6C\x65\x7C\x73\x72\x63\x7C\x6E\x75\x6D\x70\x6F\x73\x74\x73\x31\x7C\x63\x6F\x6E\x74\x65\x6E\x74\x7C\x7C\x7C\x7C\x77\x72\x69\x74\x65\x7C\x73\x75\x6D\x6D\x61\x72\x79\x7C\x6D\x6F\x6E\x74\x68\x32\x7C\x64\x61\x79\x7C\x74\x65\x72\x6D\x7C\x4D\x61\x74\x68\x7C\x74\x6D\x62\x7C\x74\x72\x74\x64\x7C\x64\x61\x79\x73\x74\x72\x7C\x69\x6D\x61\x67\x65\x7C\x72\x65\x63\x65\x6E\x74\x7C\x6D\x61\x78\x7C\x72\x65\x73\x75\x6C\x74\x73\x7C\x66\x6C\x6F\x6F\x72\x7C\x72\x61\x6E\x64\x6F\x6D\x7C\x73\x68\x6F\x77\x52\x61\x6E\x64\x6F\x6D\x49\x6D\x67\x7C\x68\x32\x7C\x73\x75\x62\x73\x74\x72\x7C\x66\x75\x6E\x63\x74\x69\x6F\x6E\x7C\x61\x6C\x74\x65\x72\x6E\x61\x74\x65\x7C\x72\x65\x70\x6C\x69\x65\x73\x7C\x4A\x61\x6E\x7C\x46\x65\x62\x7C\x4D\x61\x72\x7C\x41\x70\x72\x7C\x4D\x61\x79\x7C\x4A\x75\x6E\x7C\x4A\x75\x6C\x7C\x41\x75\x67\x7C\x53\x65\x70\x7C\x4F\x63\x74\x7C\x4E\x6F\x76\x7C\x44\x65\x63\x7C\x74\x79\x70\x65\x7C\x73\x75\x62\x73\x74\x72\x69\x6E\x67\x7C\x74\x65\x78\x74\x7C\x68\x74\x6D\x6C\x7C\x35\x30\x7C\x70\x61\x72\x73\x65\x49\x6E\x74\x7C\x75\x6C\x7C\x72\x65\x70\x6C\x61\x63\x65\x7C\x73\x31\x36\x30\x30\x7C\x73\x35\x30\x30\x7C\x6E\x65\x77\x7C\x73\x65\x61\x72\x63\x68\x7C\x6C\x69\x7C\x63\x6F\x6D\x6D\x65\x6E\x74\x7C\x6C\x61\x62\x65\x6C\x7C\x41\x72\x72\x61\x79\x7C\x70\x75\x62\x6C\x69\x73\x68\x65\x64\x7C\x72\x65\x6D\x6F\x76\x65\x48\x74\x6D\x6C\x54\x61\x67\x7C\x74\x68\x75\x6D\x62\x7C\x73\x6C\x69\x64\x65\x72\x7C\x66\x6C\x65\x78\x7C\x63\x61\x70\x74\x69\x6F\x6E\x7C\x61\x74\x74\x61\x63\x68\x6D\x65\x6E\x74\x7C\x66\x65\x61\x74\x75\x72\x65\x64\x7C\x6E\x75\x6D\x62\x65\x72\x7C\x73\x68\x6F\x77\x72\x65\x63\x65\x6E\x74\x70\x6F\x73\x74\x73\x31\x7C\x6D\x65\x74\x61\x7C\x69\x6E\x66\x6F\x7C\x6E\x61\x6D\x65\x7C\x6F\x6E\x7C\x75\x72\x69\x7C\x77\x70\x7C\x31\x34\x30\x7C\x6D\x6F\x72\x65\x7C\x43\x6C\x69\x63\x6B\x7C\x74\x6F\x7C\x43\x6F\x6E\x74\x69\x6E\x75\x65\x7C\x73\x68\x6F\x77\x72\x65\x63\x65\x6E\x74\x70\x6F\x73\x74\x73\x32\x7C\x73\x6C\x69\x64\x65\x73\x7C\x62\x6F\x78\x7C\x70\x75\x6C\x6C\x7C\x6C\x65\x66\x74\x7C\x77\x69\x64\x74\x68\x7C\x66\x6C\x65\x78\x73\x6C\x69\x64\x65\x72\x7C\x68\x65\x69\x67\x68\x74\x7C\x63\x6F\x6E\x74","","\x66\x72\x6F\x6D\x43\x68\x61\x72\x43\x6F\x64\x65","\x72\x65\x70\x6C\x61\x63\x65","\x5C\x77\x2B","\x5C\x62","\x67"];eval(function(_0x6756x1,_0x6756x2,_0x6756x3,_0x6756x4,_0x6756x5,_0x6756x6){_0x6756x5=function(_0x6756x3){return (_0x6756x3<_0x6756x2?_0x883f[4]:_0x6756x5(parseInt(_0x6756x3/_0x6756x2)))+((_0x6756x3=_0x6756x3%_0x6756x2)>35?String[_0x883f[5]](_0x6756x3+29):_0x6756x3.toString(36))};if(!_0x883f[4][_0x883f[6]](/^/,String)){while(_0x6756x3--){_0x6756x6[_0x6756x5(_0x6756x3)]=_0x6756x4[_0x6756x3]||_0x6756x5(_0x6756x3)};_0x6756x4=[function(_0x6756x5){return _0x6756x6[_0x6756x5]}];_0x6756x5=function(){return _0x883f[7]};_0x6756x3=1;};while(_0x6756x3--){if(_0x6756x4[_0x6756x3]){_0x6756x1=_0x6756x1[_0x883f[6]]( new RegExp(_0x883f[8]+_0x6756x5(_0x6756x3)+_0x883f[8],_0x883f[9]),_0x6756x4[_0x6756x3])}};return _0x6756x1;}(_0x883f[0],62,144,_0x883f[3][_0x883f[2]](_0x883f[1]),0,{}));

function stripHtmlTags1(s){return s.replace(/<a.*?>/ig, '')}
function showrecentcomments(json) {
for (var i = 0; i < 4; i++) {
var entry = json.feed.entry[i];
var ctlink;
if (i == json.feed.entry.length) break;
for (var k = 0; k < entry.link.length; k++) {
if (entry.link[k].rel == 'alternate') {
ctlink = entry.link[k].href;
break;
}
}
ctlink = ctlink.replace("#", "#comment-");
var ptlink = ctlink.split("#");
ptlink = ptlink[0];
var txtlink = ptlink.split("/");
txtlink = txtlink[5];
txtlink = txtlink.split(".html");
txtlink = txtlink[0];
var pttitle = txtlink.replace(/-/g," ");
pttitle = pttitle.link(ptlink);
if ("content" in entry) {
var comment = entry.content.$t;}
else
if ("summary" in entry) {
var comment = entry.summary.$t;}
else var comment = "";
var re = /<\S[^>]*>>/g;
comment = comment.replace(re, "");
document.write('<li>');
commentauthor1 = entry.author[0].name.$t;
commentauthor = stripHtmlTags(commentauthor1,40);
document.write('<div class="small"><i class="icon-comment-alt"></i> ' + commentauthor + '</div>');
if (comment.length < 100) {
document.write('<div class="comments-custom_txt"><a target="_blank" href="' + ctlink + '">'+stripHtmlTags1(comment)+ '</a></div>');
}
else
{
comment = comment.substring(0, 100);
var quoteEnd = comment.lastIndexOf(" ");
comment = comment.substring(0, quoteEnd);
document.write('<div class="comments-custom_txt"><a target="_blank" href="' + ctlink + '">'+stripHtmlTags1(comment) + '...</a></div>');
}
}
document.write('</li>');
}

function createThumb(pID){ 
 var div = document.getElementById(pID); 
 var content = div.innerHTML.replace(/<img.*?>/ig,'').replace(/<iframe.*?>/ig,''); 
 var img = div.getElementsByTagName("img"); 
 
if(img.length ==1) { 
	var imgurl=img[0].src;
	var thumb = imgurl.replace('/s72-c/','/s500-c/');
	var summary1 = '<img src="'+thumb+'">';
	}
else {
     if(img.length > 1) {
		var li = '';
		for(var i=0; i<img.length; i++){
			var li = li + '<li style=" overflow:hidden;"><img alt="'+img[i].alt+'" src="'+img[i].src+'"/></li>';	
		}
		var thumb = '<div class="post-gallery"><div class="flexslider no-arrow"><ul class="slides">'+li+'</ul></div></div>';
		var summary1 = thumb;
	}	
else {
   var frame = div.getElementsByTagName("iframe");
   if (frame.length >=1) {
   var iframe1 = frame[0].src;
   var thumb = '<iframe width="100%" height="450" frameborder="no" src="'+iframe1+'" scrolling="no"></iframe>';
   var summary1 = thumb;
	}		
	else {
		var imgurl="http://images.puella-magi.net/thumb/2/27/No_Image_Wide.svg/800px-No_Image_Wide.svg.png?20110202071158";   
		var thumb = imgurl;
	}
}
}


var thumbnail = document.getElementById("thumb"+pID); 

thumbnail.innerHTML = summary1; 
div.innerHTML = stripHtmlTags(content,85)
div.style.display = "block";  
}