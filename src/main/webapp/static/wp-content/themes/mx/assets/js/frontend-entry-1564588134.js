!function (e) {
    function t(a) {
        if (n[a]) return n[a].exports;
        var o = n[a] = {exports: {}, id: a, loaded: !1};
        return e[a].call(o.exports, o, o.exports, t), o.loaded = !0, o.exports
    }

    var n = {};
    return t.m = e, t.c = n, t.p = "/assets/", t(0)
}([function (e, t, n) {
    n(24)(), n(29)(), n(28)(), n(27)(), n(23)(), n(30)(), n(31)(), n(26)(), n(14)(), n(15)(), n(19)(), n(16)(), n(35)(), n(17)();
    var a = n(11);
    a.init(), n(20)(), n(21)(), n(22)(), n(48)()
}, function (e, t) {
    e.exports = function (e) {
        "loading" != document.readyState ? e() : document.addEventListener ? document.addEventListener("DOMContentLoaded", e) : document.attachEvent("onreadystatechange", function () {
            "loading" != document.readyState && e()
        })
    }
}, function (e, t) {
    e.exports = function () {
        var e, t = Array.prototype.slice.call(arguments), n = t.length, a = {}, o = "", r = 0, i = 0, s = 0, c = 0,
            l = Object.prototype.toString, u = !0;
        for (s = 0; n > s; s++) if ("[object Array]" !== l.call(t[s])) {
            u = !1;
            break
        }
        if (u) {
            for (u = [], s = 0; n > s; s++) u = u.concat(t[s]);
            return u
        }
        for (s = 0, c = 0; n > s; s++) if (e = t[s], "[object Array]" === l.call(e)) for (i = 0, r = e.length; r > i; i++) a[c++] = e[i]; else for (o in e) e.hasOwnProperty(o) && (parseInt(o, 10) + "" === o ? a[c++] = e[o] : a[o] = e[o]);
        return a
    }
}, function (e, t, n) {
    var a = n(9), o = n(4), r = {}, i = document;
    e.exports = function (e, t, n) {
        function s(e) {
            r.$c.innerHTML = '<b class="number">' + e + "</b>"
        }

        function c() {
            r.$t_container.classList.remove("show")
        }

        r || (r = {}), r.si || (r.si = !1), r.$t_container || (r.$c = i.createElement("i"), r.$c.setAttribute("class", "btn-close fa fa-times fa-fw"), r.$t_container = i.createElement("div"), r.$t_container.id = "ajax-loading-container", r.$t = i.createElement("div"), r.$t.id = "ajax-loading", r.$t_container.appendChild(r.$t), r.$t_container.appendChild(r.$c), i.body.appendChild(r.$t_container), r.$c.addEventListener(o, function () {
            c(), clearInterval(r.si)
        })), clearInterval(r.si), n > 0 ? (s(n), r.si = setInterval(function () {
            n--, s(n), 0 >= n && (c(), r.$c.innerHTML = "", r.si && clearInterval(r.si))
        }, 1e3)) : r.$c.innerHTML = "", "hide" === e ? c() : (setTimeout(function () {
            r.$t_container.className = e + " show"
        }, 1), r.$t.innerHTML = a(e, t))
    }
}, function (e, t) {
    e.exports = "touchend" in document.documentElement ? "touchend" : "click"
}, function (e, t) {
    e.exports = function (e) {
        var t = document.createElement("div");
        return t.innerHTML = e, t.firstChild
    }
}, function (e, t) {
    e.exports = function (e) {
        "use strict";

        function t() {
            o = window.pageYOffset, n()
        }

        function n() {
            r || (requestAnimationFrame(a), r = !0)
        }

        function a() {
            e(o), r = !1
        }

        var o = window.pageYOffset, r = !1;
        window.addEventListener("scroll", t)
    }
}, function (e, t) {
    e.exports = function (e) {
        for (var t = e.offsetTop, n = e.offsetParent; null !== n;) t += n.offsetTop, n = n.offsetParent;
        return t
    }
}, function (e, t) {
    e.exports = function (e, t) {
        var n = function (e) {
            return .5 > e ? 4 * e * e * e : (e - 1) * (2 * e - 2) * (2 * e - 2) + 1
        }, a = function (e, t, a, o) {
            return a > o ? t : e + (t - e) * n(a / o)
        }, o = function (t, n, o, r) {
            n = n || 500, r = r || window;
            var i = window.pageYOffset, s = parseInt(e), c = +new Date,
                l = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || function (e) {
                    window.setTimeout(e, 15)
                }, u = function () {
                    var e = +new Date - c;
                    r !== window ? r.scrollTop = a(i, s, e, n) : window.scroll(0, a(i, s, e, n)), e > n ? "function" == typeof o && o(t) : l(u)
                };
            u()
        };
        o(e)
    }
}, function (module, exports) {
    module.exports = function () {
        var defaults = ["type", "size", "content", "wrapper"],
            types = ["loading", "success", "error", "question", "info", "ban", "warning"],
            sizes = ["small", "middle", "large"], wrappers = ["div", "span"], type, icon, size, wrapper, content,
            args = arguments;
        switch (args.length) {
            case 0:
                return !1;
            case 1:
                content = args[0];
                break;
            case 2:
                type = args[0], content = args[1];
                break;
            default:
                for (var i in args) eval(defaults[i] + " = args[i];")
        }
        switch (type || (type = types[0]), size || (size = sizes[0]), wrapper || (wrapper = wrappers[0]), type) {
            case"success":
                icon = "check-circle";
                break;
            case"error":
                icon = "times-circle";
                break;
            case"info":
            case"warning":
                icon = "exclamation-circle";
                break;
            case"question":
            case"help":
                icon = "question-circle";
                break;
            case"ban":
                icon = "minus-circle";
                break;
            case"loading":
            case"spinner":
                icon = "circle-o-notch fa-spin";
                break;
            default:
                icon = type
        }
        return "<" + wrapper + ' class="tip-status tip-status-' + size + " tip-status-" + type + '"><i class="fa fa-' + icon + ' fa-fw"></i> ' + content + "</" + wrapper + ">"
    }
}, function (e, t, n) {
    var a = n(3);
    e.exports = function () {
        this.process_url = !1, this.loading_tx = !1, this.error_tx = "Sorry, the server is busy, please try again later.", this.$fm = !1, this.done_close = !1, this.done = function () {
        }, this.before = function () {
        }, this.always = function () {
        }, this.fail = function () {
        };
        var e = this, t = {};
        this.init = function () {
            e.$fm.addEventListener("submit", n.init, !1)
        };
        var n = {
            init: function () {
                t.$submit || (t.$submit = e.$fm.querySelector(".submit"), t.submit_ori_tx = t.$submit.innerHTML, t.submit_loading_tx = e.loading_tx ? e.loading_tx : t.$submit.getAttribute("data-loading-text")), t.$submit.innerHTML = t.submit_loading_tx, t.$submit.setAttribute("disabled", !0), a("loading", t.submit_loading_tx);
                var n = new XMLHttpRequest;
                fd = new FormData(e.$fm), fd.append("theme-nonce", window.DYNAMIC_REQUEST["theme-nonce"]), e.before(fd), n.open("POST", e.process_url), n.send(fd), n.onload = function () {
                    if (n.status >= 200 && n.status < 400) {
                        var o;
                        try {
                            o = JSON.parse(n.responseText)
                        } catch (r) {
                            o = n.responseText
                        }
                        if (o && o.status) {
                            if ("success" === o.status) e.done_close ? a(o.status, o.msg, e.done_close) : a(o.status, o.msg); else if ("error" === o.status) {
                                if (a(o.status, o.msg), o.code && -1 !== o.code.indexOf("pwd")) {
                                    var i = e.$fm.querySelector("input[type=password]");
                                    i && i.select()
                                } else if (o.code && -1 !== o.code.indexOf("email")) {
                                    var s = e.$fm.querySelector("input[type=email]");
                                    s && s.select()
                                }
                                t.$submit.removeAttribute("disabled")
                            }
                            t.$submit.innerHTML = t.submit_ori_tx, e.done(o)
                        } else a("error", e.error_tx), t.$submit.removeAttribute("disabled"), t.$submit.innerHTML = t.submit_ori_tx, e.fail(o);
                        e.always(o)
                    }
                }, n.onerror = function () {
                    a("error", e.error_tx), t.$submit.removeAttribute("disabled"), t.$submit.innerHTML = t.submit_ori_tx, e.fail()
                }
            }
        };
        return this
    }
}, function (e, t, n) {
    function a() {
        function e(e) {
            e.preventDefault(), f.$as[1].click()
        }

        if (f.$nagi) {
            var t = f.$post_content.querySelectorAll("a > img"), n = t.length;
            if (0 != n) for (var a = 0; n > a; a++) {
                var o = t[a].parentNode;
                o.href = "javascript:;", o.addEventListener(d, e)
            }
        }
    }

    function o() {
        function e(e) {
            return f.post_contents && f.post_contents[e] ? f.post_contents[e] : !1
        }

        function t(e, t) {
            f.post_contents || (f.post_contents = []), f.post_contents[e] = t
        }

        function n(e) {
            f.$post_content.innerHTML = e
        }

        function o() {
            return f.$current == f.$next ? g.page + 1 : g.page - 1
        }

        function r(t) {
            if (t.preventDefault(), f.$current = this, p()) return i("warning", g.lang.M03, 3), !1;
            if (_()) return i("warning", g.lang.M04, 3), !1;
            if (e(o())) return n(e(o())), m(), u(), void a();
            i("loading", window.THEME_CONFIG.lang.M01);
            var r = new XMLHttpRequest;
            r.open("get", g.process_url + "&page=" + o()), r.send(), r.onload = function () {
                if (r.status >= 200 && r.status < 400) {
                    var e;
                    try {
                        e = JSON.parse(r.responseText)
                    } catch (t) {
                        e = r.responseText
                    }
                    e && e.status ? s(e) : l(e)
                } else l()
            }, r.onerror = function () {
                l()
            }
        }

        function s(e) {
            "success" === e.status ? (t(o(), e.content), n(e.content), m(), u(), a(), i("hide")) : "error" === e.status && i(e.status, e.msg)
        }

        function l(e) {
            e ? i("error", e) : i("error", g.lang.E01)
        }

        function u() {
            var e = g.url_tpl.replace(9999, g.page);
            history.replaceState(null, null, e), c(f.post_top)
        }

        function m() {
            g.page = o(), f.$next_number.innerHTML = g.page, f.$prev_number.innerHTML = g.page
        }

        function p() {
            return f.$current == f.$prev && 1 == g.page
        }

        function _() {
            return f.$current == f.$next && g.page == g.numpages
        }

        if (f.$nagi) {
            f.$post_content = document.querySelector(".entry-content"), f.$as = f.$nagi.querySelectorAll("a");
            for (var v = 0, h = f.$as.length; h > v; v++) f.$as[v].addEventListener(d, r);
            t(g.page, f.$post_content.innerHTML)
        }
    }

    function r() {
        return window.THEME_CONFIG.theme_page_nagination_ajax ? void u(function () {
            _.init(), o(), a()
        }) : !1
    }

    var i = n(3), s = n(2), c = n(8), l = n(6), u = n(1), d = n(4), m = n(7), p = n(12), f = {}, g = {
        process_url: "",
        post_id: "",
        numpages: "",
        url_tpl: "",
        page: 1,
        lang: {
            M01: "Loading, please wait...",
            M02: "Content loaded.",
            M03: "Already first page.",
            M04: "Already last page.",
            E01: "Sorry, some server error occurred, the operation can not be completed, please try again later."
        }
    };
    g = s(g, window.THEME_CONFIG.theme_page_nagination_ajax);
    var _ = {
        init: function () {
            var e = this;
            f.$post = document.querySelector(".singular-post"), f.$nagi = document.querySelector(".page-pagination"), f.$next = f.$nagi.querySelector(".next"), f.$prev = f.$nagi.querySelector(".prev"), f.$next_number = f.$next.querySelector(".current-page"), f.$prev_number = f.$prev.querySelector(".current-page"), f.$post && f.$nagi && (f.last_scroll_y = window.pageYOffset, f.ticking = !1, f.post_top, f.max_bottom, f.is_hide = !1, window.addEventListener("resize", function () {
                e.reset_nagi_style()
            }), this.bind())
        }, bind: function (e) {
            e === !0 && (f.$nagi = document.querySelector(".page-pagination")), this.reset_nagi_style(), this.bind_scroll()
        }, reset_nagi_style: function () {
            f.post_top = m(f.$post), f.post_height = f.$post.querySelector(".entry-body").clientHeight, f.max_bottom = f.post_top + f.post_height, f.$nagi.style.left = p(f.$post) + "px", f.$nagi.style.width = f.$post.clientWidth + "px"
        }, bind_scroll: function () {
            function e(e) {
                e >= f.max_bottom - 250 ? t && (f.$nagi.classList.remove("fixed"), t = !1) : t || (f.$nagi.classList.add("fixed"), t = !0)
            }

            var t = !1;
            l(e)
        }
    };
    e.exports.page_nagi = _, e.exports.init = r
}, function (e, t) {
    e.exports = function (e) {
        for (var t = e.offsetLeft, n = e.offsetParent; null !== n;) t += n.offsetLeft, n = n.offsetParent;
        return t
    }
}, , function (e, t, n) {
    var a = n(2), o = n(1), r = n(3), i = n(5);
    e.exports = function () {
        "use strict";

        function e() {
            o(function () {
                d.set(), l.$comment_list_container = c("comment-list-" + u.post_id), l.$comments = c("comments"), window.addComment = p, m.init();
                var e = new t;
                e.lang.loading = u.lang.M01, e.lang.error = window.THEME_CONFIG.lang.E01, e.lang.prev = u.lang.M02, e.lang.next = u.lang.M03, e.lang.midd = u.lang.M04, e.pages = window.DYNAMIC_REQUEST.theme_comment_ajax.pages, e.cpage = window.DYNAMIC_REQUEST.theme_comment_ajax.cpage, e.url_format = u.pagi_process_url, e.init();
                var a = new n;
                a.init()
            })
        }

        function t() {
            function e(e, t) {
                h.comments || (h.comments = []);
                for (var n = i(t), a = [], o = 0, r = n.length; r > o; o++) {
                    var s = n[o].querySelectorAll("img");
                    if (s[0]) for (var c = 0, l = s.length; l > c; c++) a[c] = new Image, a[c].src = s[c].src
                }
                h.comments[e] = t
            }

            function t(e) {
                return h.comments && h.comments[e] ? h.comments[e] : !1
            }

            function n() {
                return $.pages <= 1 ? !1 : (h.$pagi = document.createElement("div"), h.$pagi.id = $.id, h.$pagi.setAttribute("class", "comment-pagination"), h.$pagi.appendChild(a()), h.$pagi.appendChild(c()), h.$pagi)
            }

            function a() {
                var e = $.cpage <= 1 ? "disabled" : "",
                    t = {"class": "prev btn btn-success " + e, href: "javascript:;"};
                h.$prev = document.createElement("a");
                for (var n in t) h.$prev.setAttribute(n, t[n]);
                return h.$prev.innerHTML = $.lang.prev, h.$prev.addEventListener(click_handle, o), h.$prev
            }

            function o(e) {
                return e && e.preventDefault(), $.cpage <= 1 ? !1 : (v = parseInt($.cpage) - 1, void f())
            }

            function s() {
                $.cpage <= 1 ? h.$prev.classList.add("disabled") : h.$prev.classList.remove("disabled")
            }

            function c() {
                var e = $.cpage > $.pages - 1 ? "disabled" : "",
                    t = {"class": "next btn btn-default " + e, href: "javascript:;"};
                h.$next = document.createElement("a");
                for (var n in t) h.$next.setAttribute(n, t[n]);
                return h.$next.innerHTML = $.lang.next, h.$next.addEventListener(click_handle, u), h.$next
            }

            function u(e) {
                return e && e.preventDefault(), $.cpage == $.pages ? !1 : (v = parseInt($.cpage) + 1, void f())
            }

            function d() {
                $.cpage == $.pages ? h.$next.classList.add("disabled") : h.$next.classList.remove("disabled")
            }

            function m() {
                return $.url_format.replace("=n", "=" + v)
            }

            function f() {
                if (_(), l.$comments.querySelector("#respond") && p.cancelMove(), g(), t($.cpage)) return l.$comment_list_container.innerHTML = t($.cpage), s(), d(), !1;
                r("loading", $.lang.loading);
                var n = new XMLHttpRequest;
                n.open("GET", m() + "&theme-nonce=" + window.DYNAMIC_REQUEST["theme-nonce"]), n.send(), n.onload = function () {
                    if (n.status >= 200 && n.status < 400) {
                        var t;
                        try {
                            t = JSON.parse(n.responseText)
                        } catch (a) {
                            t = n.responseText
                        }
                        t && "success" === t.status ? (l.$comment_list_container.innerHTML = t.comments, e($.cpage, t.comments), r("hide"), d(), s()) : t && "error" === t.status ? r(t.status, t.msg) : r("error", t)
                    }
                    $.always(), n = null
                }, n.onerror = function () {
                    r("error", $.lang.error)
                }
            }

            function g() {
                $.cpage >= v ? $.cpage-- : $.cpage++
            }

            function _() {
                location.hash = "#none", location.hash = "#comments"
            }

            this.id = "comment-pagination", this.container_id = "comment-pagination-container", this.cpage = 1, this.pages = 1, this.class_name = "comment-pagination", this.url_format = "", this.lang = {
                loading: "Loading, please wait...",
                error: "Sorry, some server error occurred, the operation can not be completed, please try again later.",
                prev: "Previous",
                next: "Next",
                midd: "{n} page"
            }, this.before = function () {
            }, this.done = function () {
            }, this.faild = function () {
            }, this.always = function () {
            };
            var v, h = {}, $ = this;
            this.init = function () {
                return h.$container = document.getElementById($.container_id), h.$container ? (h.$container.appendChild(n()), void e($.cpage, l.$comment_list_container.innerHTML)) : !1
            }
        }

        function n() {
            function e() {
                return s.$respond = c("respond"), s.$fm = c("commentform"), s.$must_logged = c("respond-must-login"), s.$loading_ready = c("respond-loading-ready"), s.$avatar = c("respond-avatar"), s.$area_visitor = c("area-respond-visitor"), s.$comment_parent = c("comment_parent"), s.$comment_ta = c("comment-form-comment"), s.$respond && s.$fm ? (s.$submit_btn = s.$fm.querySelector(".submit"), s.$loading_ready && s.$loading_ready.parentNode.removeChild(s.$loading_ready), d.registration && !d.logged ? (s.$must_logged.style.display = "block", !1) : (s.$comment_ta && s.$comment_ta.addEventListener("keydown", function (e) {
                    return 13 == e.keyCode && e.ctrlKey ? (s.$submit_btn.click(), !1) : void 0
                }, !1), d.logged ? (s.$avatar && (s.$avatar.src = window.DYNAMIC_REQUEST.theme_comment_ajax["avatar-url"]), s.$area_visitor && s.$area_visitor.parentNode.removeChild(s.$area_visitor)) : t(), s.$fm.style.display = "block", void s.$fm.addEventListener("submit", n))) : !1
            }

            function t() {
                return d.logged ? !1 : (s.$comment_form_author = c("comment-form-author"), s.$comment_form_email = c("comment-form-email"), s.$comment_form_author && s.$comment_form_email ? (window.DYNAMIC_REQUEST.theme_comment_ajax["user-name"] && (s.$comment_form_author.value = window.DYNAMIC_REQUEST.theme_comment_ajax["user-name"]), void (window.DYNAMIC_REQUEST.theme_comment_ajax["user-email"] && (s.$comment_form_email.value = window.DYNAMIC_REQUEST.theme_comment_ajax["user-email"]))) : !1)
            }

            function n(e) {
                if ("" === s.$comment_ta.value.trim()) return s.$comment_ta.focus(), r("error", s.$comment_ta.getAttribute("title"), 3), !1;
                if (!d.logged && d.registration) for (var t = s.$fm.querySelectorAll("input[required]"), n = 0, o = t.length; o > n; n++) {
                    if ("email" === t[n].getAttribute("type") && !is_email(t[n].value)) return r("error", t[n].getAttribute("title"), 3), !1;
                    if ("" === t[n].value.trim()) return r("error", t[n].getAttribute("title"), 3), !1
                }
                return r("loading", u.lang.M01), s.$submit_btn.setAttribute("disabled", !0), a(), !1
            }

            function a() {
                var e = new XMLHttpRequest, t = new FormData(s.$fm);
                t.append("theme-nonce", window.DYNAMIC_REQUEST["theme-nonce"]), e.open("POST", u.process_url), e.send(t), e.onload = function () {
                    if (e.status >= 200 && e.status < 400) {
                        var t;
                        try {
                            t = JSON.parse(e.responseText)
                        } catch (n) {
                            t = e.responseText
                        }
                        if (t && "success" === t.status) {
                            t.comment = t.comment.replace("srcset", "data-srcset");
                            var a = i(t.comment);
                            if (a.classList.add("new"), 0 != s.$comment_parent.value) {
                                var o = c(d.prefix_comment_body_id + s.$comment_parent.value);
                                o.insertAdjacentHTML("afterend", '<ul class="children">' + a.innerHTML + "</ul>"), p.cancelMove()
                            } else l.$comment_list_container.appendChild(a);
                            s.$comment_ta.value = "";
                            var u = l.$comments.querySelector(".comment-loading");
                            u && u.parentNode.removeChild(u);
                            var m = c("comment-number-" + t.post_id);
                            m && (isNaN(m.innerHTML) ? m.innerHTML = 1 : m.innerHTML++), l.$comments.style.display = "block", r(t.status, t.msg, 3)
                        } else t && "error" === t.status ? (r(t.status, t.msg), s.$comment_ta.focus()) : (r("error", t), s.$comment_ta.select())
                    } else r("error", window.THEME_CONFIG.lang.E01);
                    s.$submit_btn.removeAttribute("disabled")
                }, e.onerror = function () {
                    r("error", window.THEME_CONFIG.lang.E01), s.$submit_btn.removeAttribute("disabled")
                }
            }

            function o() {
                return s.$goto = c("goto-comment"), s.$comment = c("comment-form-comment"), s.$goto && s.$comment ? (s.$goto.style.display = "block", void (s.$goto.onclick = function () {
                    s.$comment.focus()
                })) : !1
            }

            var s = {}, d = {
                logged: window.DYNAMIC_REQUEST.theme_comment_ajax.logged,
                registration: window.DYNAMIC_REQUEST.theme_comment_ajax.registration,
                prefix_comment_body_id: "comment-body-"
            };
            this.init = function () {
                o(), e()
            }
        }

        function s() {
            if (!location.hash || "" === location.hash) return !1;
            var e = location.hash, t = c(e.substr(1));
            return t ? (location.hash = "e", void (location.hash = e)) : !1
        }

        function c(e) {
            return document.getElementById(e)
        }

        if (!window.THEME_CONFIG.theme_comment_ajax) return !1;
        var l = {}, u = {
            process_url: "",
            pagi_process_url: "",
            post_id: "",
            lang: {M01: "Loading, please wait...", M02: "Previous", M03: "Next", M04: "{n} page"}
        };
        u = a(u, window.THEME_CONFIG.theme_comment_ajax);
        var d = {
            set: function (e) {
                return l.$count = c("comment-number-" + u.post_id), l.$count ? void (l.$count.innerHTML = e ? e : window.DYNAMIC_REQUEST.theme_comment_ajax.count) : !1
            }
        }, m = {
            init: function () {
                return window.DYNAMIC_REQUEST.theme_comment_ajax.comments ? (l.$comment_list_container.innerHTML = window.DYNAMIC_REQUEST.theme_comment_ajax.comments, void s()) : !1
            }, get: function () {
                var e = this, t = new XMLHttpRequest, n = n({
                    type: "get-comments",
                    "post-id": u.post_id,
                    "theme-nonce": window.DYNAMIC_REQUEST["theme-nonce"]
                });
                t.open("GET", u.pagi_process_url + "&" + n), t.send(), t.onload = function () {
                    if (t.status >= 200 && t.status < 400) {
                        var n;
                        try {
                            n = JSON.parse(t.responseText)
                        } catch (a) {
                            n = t.responseText
                        }
                        n && n.status ? e.done(n) : e.fail(n), e.always(n)
                    }
                }
            }, done: function (e) {
                "success" === e.status && (l.$comment_list_container.innerHTML = e.comments)
            }, faild: function (e) {
            }, always: function (e) {
            }
        }, p = {
            cache: {}, cancelMove: function () {
                var e = this;
                e.cache.$parent.value = "0", e.cache.$tmp.parentNode.insertBefore(e.cache.$respond, e.cache.$tmp), e.cache.$cancel.style.display = "none", e.cache.$cancel.onclick = null
            }, moveForm: function (e, t, n, a) {
                var o = this;
                return o.cache.$comm = c(e), o.cache.$respond = c(n), o.cache.$cancel = c("cancel-comment-reply-link"), o.cache.$parent = c("comment_parent"), o.cache.$post = c("comment_post_ID"), o.cache.$comment = c("comment-form-comment"), o.cache.$comm && o.cache.$respond && o.cache.$cancel && o.cache.$parent ? (a = a || !1, o.cache.$tmp || (o.cache.$tmp = document.createElement("div"), o.cache.$tmp.id = "wp-temp-form-div", o.cache.$tmp.style.display = "none", o.cache.$respond.parentNode.insertBefore(o.cache.$tmp, o.cache.$respond)), o.cache.$comm.parentNode.insertBefore(o.cache.$respond, o.cache.$comm.nextSibling), o.cache.$post && a && (o.cache.$post.value = a), o.cache.$parent.value = t, o.cache.$cancel.style.display = "block", o.cache.$cancel.onclick = function () {
                    return o.cancelMove(), !1
                }, o.cache.$comment && o.cache.$comment.focus(), !1) : void 0
            }
        };
        e()
    }
}, function (e, t, n) {
    var a = n(1), o = n(4);
    e.exports = function () {
        "use strict";

        function e() {
            c.$emotion_btns = document.querySelectorAll(".comment-emotion-pop-btn"), c.$pop = document.querySelectorAll(".comment-emotion-area-pop .pop"), c.$comment = s("comment-form-comment"), c.$emotion_faces = document.querySelectorAll(".comment-emotion-area-pop a"), c.$emotion_btns[0] && (c.pop_hide = [], c.replaced = [], i(), t())
        }

        function t() {
            function e(e) {
                e && e.preventDefault(), c.$comment.focus();
                var t = c.$comment.selectionStart, n = c.$comment.value;
                c.$pop[c.active_pop_i].style.display = "none", c.$comment.value = n.substring(0, t) + " " + this.getAttribute("data-content") + " " + n.substring(t)
            }

            for (var t = 0, n = c.$emotion_faces.length; n > t; t++) c.$emotion_faces[t].addEventListener(o, e)
        }

        function n(e) {
            e && e.stopPropagation(), c.$last_show_pop && (c.$last_show_pop.style.display = "none"), document.body.removeEventListener(o, n)
        }

        function r(e) {
            e && e.stopPropagation();
            for (var t = 0, a = c.$pop.length; a > t; t++) c.pop_hide[t] !== !0 && (c.$pop[t].style.display = "none", c.pop_hide[t] = !0), this == c.$emotion_btns[t] && (c.active_pop_i = t, c.pop_hide[t] = !1, c.$pop[t].style.display = "block", c.$last_show_pop = c.$pop[t]);
            if (!c.replaced[c.active_pop_i]) {
                c.replaced[c.active_pop_i] = !0;
                for (var r = c.$pop[c.active_pop_i].querySelectorAll("img"), t = 0, a = r.length; a > t; t++) r[t].src = r[t].getAttribute("data-url"), r[t].removeAttribute("data-url")
            }
            document.body.addEventListener(o, n)
        }

        function i() {
            for (var e = 0, t = c.$emotion_btns.length; t > e; e++) c.$emotion_btns[e].addEventListener(o, r)
        }

        function s(e) {
            return document.getElementById(e)
        }

        a(e);
        var c = {}
    }
}, function (e, t, n) {
    var a = n(1), o = n(8), r = n(12), i = n(7), s = n(25), c = n(6);
    e.exports = function () {
        "use strict";

        function e() {
            m.$boxes = document.querySelectorAll(".homebox"), m.$boxes[0] && (m.len = m.$boxes.length, m.$last_boxes = m.$boxes[m.len - 1], m.ori_bottom = i(m.$last_boxes) + m.$last_boxes.offsetHeight, m.ori_offset_left = r(m.$boxes[0]), m.ori_offset_top = i(m.$boxes[0]), d(), t())
        }

        function t() {
            function e(e) {
                e >= m.target_datas[0].offset_top ? m.is_fixed || (m.$nav.style.position = "fixed", m.$nav.style.top = m.main_nav_gutter + "px", m.is_fixed = !0) : m.is_fixed && (m.$nav.style.position = "absolute", m.$nav.style.top = m.ori_offset_top + "px", m.is_fixed = !1);
                for (var t = 0, n = m.target_datas.length; n > t; t++) e >= m.target_datas[t].offset_top && e < m.target_datas[t].offset_top + m.target_datas[t].height ? m.$items[t].classList.add("active") : m.$items[t].classList.remove("active")
            }

            c(e)
        }

        function n() {
            m.$nav.style.left = m.ori_offset_left + "px", m.$nav.style.top = m.ori_offset_top + "px"
        }

        function l(e) {
            e.preventDefault(), o(this.getAttribute("data-scroll-top"))
        }

        function u() {
            for (var e = 0, t = m.$boxes.length; t > e; e++) {
                var n = m.$boxes[e].querySelector(".title a"), a = n.textContent || n.innerText,
                    o = n.querySelector("i"), r = i(m.$boxes[e]) - m.main_nav_gutter, s = document.createElement("a");
                if (o) {
                    var c = o.getAttribute("class");
                    m.target_datas[e] = {
                        offset_top: r,
                        height: parseInt(getComputedStyle(m.$boxes[e]).marginBottom) + m.$boxes[e].clientHeight
                    }, s.setAttribute("data-scroll-top", r), s.href = "#" + m.$boxes[e].id, s.title = a, s.innerHTML = '<i class="' + c + ' fa-fw"></i>', s.addEventListener("click", l), m.$items[e] = s, m.$nav.appendChild(m.$items[e])
                }
            }
        }

        function d() {
            m.$nav = document.createElement("nav"), m.$nav.id = "homebox-nav", u(), n(), document.body.appendChild(m.$nav)
        }

        if (!s) {
            var m = {is_fixed: !1, target_datas: [], $items: [], main_nav_gutter: 70};
            a(e)
        }
    }
}, function (e, t, n) {
    var a = n(3), o = n(1), r = n(2);
    e.exports = function () {
        "use strict";

        function e() {
            o(t)
        }

        function t() {
            if (s.$btns = document.querySelectorAll(".post-point-btn"), !s.$btns[0]) return !1;
            for (var e = 0, t = s.$btns.length; t > e; e++) s.$btns[e].addEventListener("click", n)
        }

        function n(e) {
            function t(e) {
                "success" === e.status ? (a(e.status, e.msg, 3), s.$number.innerHTML = e.points) : a(e.status, e.msg)
            }

            function n(e) {
                a("error", window.THEME_CONFIG.lang.E01)
            }

            e.preventDefault(), e.stopPropagation();
            var o = this.getAttribute("data-post-id"), r = this.getAttribute("data-points");
            s.$number = i("post-point-number-" + o), a("loading", window.THEME_CONFIG.lang.M01);
            var l = new XMLHttpRequest, u = new FormData;
            u.append("post-id", o), u.append("points", r), u.append("theme-nonce", window.DYNAMIC_REQUEST["theme-nonce"]), l.open("post", c.process_url), l.send(u), l.onload = function () {
                if (l.status >= 200 && l.status < 400) {
                    var e;
                    try {
                        e = JSON.parse(l.responseText)
                    } catch (o) {
                        e = l.responseText
                    }
                    e && e.status ? t(e) : n(e)
                } else a("error", window.THEME_CONFIG.lang.E01)
            }, l.onerror = function () {
                a("error", window.THEME_CONFIG.lang.E01)
            }
        }

        function i(e) {
            return document.getElementById(e)
        }

        if (window.THEME_CONFIG.custom_post_point) {
            var s = {}, c = {process_url: ""};
            c = r(c, window.THEME_CONFIG.custom_post_point), e()
        }
    }
}, , function (module, exports, __webpack_require__) {
    var ready = __webpack_require__(1), array_merge = __webpack_require__(2);
    module.exports = function () {
        "use strict";

        function bind() {
            cache.$container = document.querySelector(".theme_custom_slidebox-container"), cache.$container && (cache.$main = cache.$container.querySelector(".area-main"), cache.$blurs = cache.$container.querySelectorAll(".area-blur .item"), eval(config.type + "();"))
        }

        function scroller() {
            function e(e) {
                o || (o = !0), a || (a = e.clientX), cache.$main.scrollLeft >= 0 && (cache.$main.scrollLeft = cache.$main.scrollLeft - (a - e.clientX)), a = e.clientX
            }

            function t(e) {
                o && (o = !1), e.target.width || (a = 0)
            }

            function n() {
                function e(e) {
                    var t = this.getAttribute("data-i");
                    if (cache.current_i == t) return !1;
                    cache.current_i = t;
                    for (var n = 0; n < cache.len; n++) cache.$blurs[n].classList.contains("active") && cache.$blurs[n].classList.remove("active"), cache.$as[n].classList.contains("active") && cache.$as[n].classList.remove("active");
                    this.classList.add("active"), cache.$blurs[t].classList.add("active")
                }

                cache.$as = cache.$main.querySelectorAll("a"), cache.current_i = 0, cache.len = cache.$as.length;
                for (var t = 0; t < cache.len; t++) cache.$as[t].setAttribute("data-i", t), cache.$as[t].addEventListener("mouseover", e)
            }

            var a, o = !1;
            cache.$main.addEventListener("mouseout", t), cache.$main.addEventListener("mousemove", e), n()
        }

        function candy() {
            function e(e) {
                var t = this.getAttribute("data-i");
                if (cache.current_i == t) return !1;
                cache.current_i = t;
                for (var n = 0; n < cache.len; n++) cache.$blurs[n].classList.contains("active") && cache.$blurs[n].classList.remove("active"), cache.$mains[n].classList.contains("active") && cache.$mains[n].classList.remove("active"), cache.$thumbnails[n].classList.contains("active") && cache.$thumbnails[n].classList.remove("active");
                this.classList.add("active"), cache.$blurs[t].classList.add("active"), cache.$mains[t].classList.add("active")
            }

            cache.$mains = cache.$container.querySelectorAll(".area-main .item"), cache.$thumbnails = cache.$container.querySelectorAll(".area-thumbnail .item"), cache.len = cache.$thumbnails.length, cache.current_i = 0;
            for (var t = 0; t < cache.len; t++) cache.$thumbnails[t].setAttribute("data-i", t), cache.$thumbnails[t].addEventListener("mouseover", e)
        }

        if (window.THEME_CONFIG.theme_custom_slidebox) {
            var cache = {}, config = {type: "candy"};
            config = array_merge(config, window.THEME_CONFIG.theme_custom_slidebox), ready(bind)
        }
    }
}, function (e, t, n) {
    var a = n(1), o = n(2), r = n(4);
    e.exports = function () {
        "use strict";

        function e() {
            a(t)
        }

        function t() {
            p.$main = m("main"), p.$side = m("sidebar-container"), p.$main && p.$side && d() && (p.$btn.addEventListener(r, u), 1 == localStorage.getItem(f.key) && s())
        }

        function i() {
            window.jQuery && jQuery(window).resize();
            try {
                n(11).page_nagi.reset_nagi_style()
            } catch (e) {
            }
        }

        function s(e) {
            p.$btn.classList.remove("fa-angle-right"), p.$btn.classList.add("fa-angle-left"), p.$main.classList.add("expand"), p.$side.classList.add("expand"), i(), e && localStorage.setItem(f.key, 1)
        }

        function c() {
            p.$btn.classList.remove("fa-angle-left"), p.$btn.classList.add("fa-angle-right"), p.$main.classList.remove("expand"), p.$side.classList.remove("expand"), i(), localStorage.removeItem(f.key)
        }

        function l() {
            return p.$main.classList.contains("expand")
        }

        function u() {
            l() ? c() : s(!0)
        }

        function d() {
            var e = document.querySelector(".singular-post");
            if (!e) return !1;
            var t = document.createElement("i");
            return t.id = "full-width-mode", t.title = f.lang.M01, t.setAttribute("class", "fa fa-angle-right fa-2x"), e && e.appendChild(t), p.$btn = t, !0
        }

        function m(e) {
            return document.getElementById(e)
        }

        if (window.THEME_CONFIG.theme_full_width_mode) {
            var p = {}, f = {key: "full-width-mode", lang: {M01: "Full width mode"}};
            f = o(f, window.THEME_CONFIG.theme_full_width_mode), e()
        }
    }
}, function (e, t, n) {
    var a = n(1);
    e.exports = function () {
        "use strict";

        function e() {
            var e = document.querySelectorAll(".bdsharebuttonbox");
            if (!e[0]) return !1;
            for (var t = {
                common: {
                    bdSnsKey: {},
                    dText: !1,
                    bdMiniList: !1,
                    bdMini: 2,
                    bdPic: !1,
                    bdStyle: !1,
                    bdSize: 16
                }, share: [], selectShare: !1
            }, n = 0, a = e.length; a > n; n++) {
                var o = "bdshare_tag_" + n, r = JSON.parse(e[n].getAttribute("data-bdshare").replace(/\'/g, '"'));
                r.bdSign = "off", r.tag = o, e[n].setAttribute("data-tag", o), t.share.push(r)
            }
            window._bd_share_config = t, setTimeout(function () {
                var e = document.createElement("script");
                e.src = "http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=" + ~(-new Date / 36e5), e.async = !0, document.getElementsByTagName("head")[0].appendChild(e)
            }, 5e3)
        }

        a(e)
    }
}, function (e, t, n) {
    var a = n(1);
    e.exports = function () {
        "use strict";

        function e() {
            if (window.DYNAMIC_REQUEST && window.DYNAMIC_REQUEST.theme_post_views) for (var e in window.DYNAMIC_REQUEST.theme_post_views) {
                var t = document.getElementById("post-views-number-" + e);
                t && (t.innerHTML = window.DYNAMIC_REQUEST.theme_post_views[e])
            }
        }

        window.THEME_CONFIG.theme_post_views && a(e)
    }
}, function (e, t, n) {
    var a = n(1);
    e.exports = function () {
        "use strict";

        function e(e) {
            this.value && (location.href = this.value)
        }

        function t() {
            for (var t = 0, a = n.length; a > t; t++) n[t].addEventListener("change", e)
        }

        var n = document.querySelectorAll(".archive-pagination select");
        n[0] && a(t)
    }
}, function (e, t, n) {
    var a = n(8), o = n(4), r = n(1);
    e.exports = function () {
        "use strict";

        function e() {
            r(function () {
                var e = document.getElementById("back-to-top");
                e && e.addEventListener(o, function (e) {
                    e.preventDefault(), a(0)
                })
            })
        }

        e()
    }
}, function (e, t) {
    e.exports = /Mobi/.test(navigator.userAgent)
}, function (e, t) {
    e.exports = function () {
        !function () {
            function e(e) {
                var t = 0;
                if (e.offsetParent) {
                    do t += e.offsetTop; while (e = e.offsetParent);
                    return t
                }
            }

            var t = window.addEventListener || function (e, t) {
                window.attachEvent("on" + e, t)
            }, n = window.removeEventListener || function (e, t) {
                window.detachEvent("on" + e, t)
            }, a = {
                cache: [], mobileScreenSize: 500, addObservers: function () {
                    t("scroll", a.throttledLoad), t("resize", a.throttledLoad)
                }, removeObservers: function () {
                    n("scroll", a.throttledLoad, !1), n("resize", a.throttledLoad, !1)
                }, throttleTimer: (new Date).getTime(), throttledLoad: function () {
                    var e = (new Date).getTime();
                    e - a.throttleTimer >= 200 && (a.throttleTimer = e, a.loadVisibleImages())
                }, loadVisibleImages: function () {
                    for (var t = window.pageYOffset || document.documentElement.scrollTop, n = window.innerHeight || document.documentElement.clientHeight, o = {
                        min: t - 200,
                        max: t + n + 200
                    }, r = 0; r < a.cache.length;) {
                        var i = a.cache[r], s = e(i), c = i.height || 0;
                        if (s >= o.min - c && s <= o.max) {
                            var l = i.getAttribute("data-src-mobile");
                            i.onload = function () {
                                this.className = this.className.replace(/(^|\s+)lazy-load(\s+|$)/, "$1lazy-loaded$2")
                            }, i.src = l && screen.width <= a.mobileScreenSize ? l : i.getAttribute("data-src"), i.removeAttribute("data-src"), i.removeAttribute("data-src-mobile"), a.cache.splice(r, 1)
                        } else r++
                    }
                    0 === a.cache.length && a.removeObservers()
                }, init: function () {
                    document.querySelectorAll || (document.querySelectorAll = function (e) {
                        var t = document, n = t.documentElement.firstChild, a = t.createElement("STYLE");
                        return n.appendChild(a), t.__qsaels = [], a.styleSheet.cssText = e + "{x:expression(document.__qsaels.push(this))}", window.scrollBy(0, 0), t.__qsaels
                    }), t("load", function e() {
                        for (var t = document.querySelectorAll("img[data-src]"), o = 0; o < t.length; o++) {
                            var r = t[o];
                            a.cache.push(r)
                        }
                        a.addObservers(), a.loadVisibleImages(), n("load", e, !1)
                    })
                }
            };
            a.init()
        }()
    }
}, function (e, t, n) {
    var a = n(4), o = n(1);
    e.exports = function () {
        "use strict";

        function e() {
            if (s.$toggles = document.querySelectorAll("a[data-mobile-target]"), s.$toggles[0]) {
                t();
                for (var e = 0, n = s.$toggles.length; n > e; e++) s.$toggles[e].addEventListener(a, i)
            }
        }

        function t() {
            s.$layer = document.createElement("div"), s.$layer.id = "mobile-on-layer", s.$layer.addEventListener(a, r), document.body.appendChild(s.$layer)
        }

        function n() {
            var e = s.$last_click_btn.getAttribute("data-icon-active"),
                t = s.$last_click_btn.getAttribute("data-icon-original");
            document.body.classList.add("menu-on"), s.$last_target.classList.add("on"), e && t && (s.$last_click_btn.classList.remove(t), s.$last_click_btn.classList.add(e));
            var n = s.$last_click_btn.getAttribute("data-focus-target");
            if (n) {
                var a = document.querySelector(n);
                a && a.focus()
            }
        }

        function r() {
            var e = s.$last_click_btn.getAttribute("data-icon-active"),
                t = s.$last_click_btn.getAttribute("data-icon-original");
            document.body.classList.remove("menu-on"), s.$last_target.classList.remove("on"), e && t && (s.$last_click_btn.classList.remove(e), s.$last_click_btn.classList.add(t))
        }

        function i(e) {
            s.$last_target = document.querySelector(this.getAttribute("data-mobile-target")), s.$last_click_btn = this, s.$last_target.classList.contains("on") ? r() : n()
        }

        var s = {};
        o(e)
    }
}, function (e, t, n) {
    var a = n(4);
    e.exports = function () {
        function e() {
            var e = r.getAttribute("data-icon-active"), t = r.getAttribute("data-icon-original");
            i.classList.add("on"), e && t && (r.classList.remove(t), r.classList.add(e));
            var n = r.getAttribute("data-focus-target");
            if (n) {
                var a = document.querySelector(n);
                a && setTimeout(function () {
                    a.focus()
                }, 500)
            }
        }

        function t(e) {
            e && e.preventDefault();
            var t = r.getAttribute("data-icon-active"), n = r.getAttribute("data-icon-original");
            i.classList.remove("on"), t && n && (r.classList.remove(t), r.classList.add(n))
        }

        function n(n) {
            i = document.querySelector(this.getAttribute("data-toggle-target")), r = this, i.classList.contains("on") ? t() : e()
        }

        var o = document.querySelectorAll("a[data-toggle-target]");
        if (o[0]) for (var r, i, s = 0, c = o.length; c > s; s++) o[s].addEventListener(a, n)
    }
}, function (e, t, n) {
    var a = n(6), o = n(1);
    e.exports = function () {
        "use strict";

        function e() {
            i.$menu = document.querySelector(".nav-main"), i.$menu && (i.menu_height = i.$menu.offsetHeight, i.y = 0, i.fold = !1, r(window.pageYOffset), a(r))
        }

        function t() {
            i.fold || (i.$menu.classList.add("fold"), i.$menu.classList.remove("top"), i.fold = !0)
        }

        function n() {
            i.fold && (i.$menu.classList.remove("fold"),
                i.fold = !1)
        }

        function r(e) {
            e <= i.menu_height ? (n(), i.$menu.classList.add("top")) : i.y <= e ? t() : i.y - e < 100 && n(), i.y = e
        }

        var i = {};
        o(e)
    }
}, function (e, t) {
    e.exports = function () {
        function e(e) {
            e && e.preventDefault(), setTimeout(function () {
                a.focus()
            }, 100)
        }

        var t = document.querySelector(".main-nav a.search");
        if (!t) return !1;
        var n = document.querySelector(t.getAttribute("data-toggle-target")),
            a = n.querySelector('input[type="search"]'), o = function () {
                return "" === a.value.trim() ? (a.focus(), !1) : void 0
            };
        t.addEventListener(click_handle, e), n.onsubmit = o
    }
}, function (e, t, n) {
    var a = n(1);
    e.exports = function () {
        function e() {
            a(t)
        }

        function t() {
            var e = document.querySelectorAll(".hide-no-js"), t = document.querySelectorAll(".hide-on-js");
            if (e[0]) for (var n = 0, a = e.length; a > n; n++) e[n].style.display = "none";
            if (t[0]) for (var n = 0, a = t.length; a > n; n++) t[n].style.display = "none"
        }

        e()
    }
}, , , , function (e, t, n) {
    var a = n(1);
    e.exports = function () {
        "use strict";

        function e() {
            return t.$thumbnail_container = document.querySelector(".attachment-slide-thumbnail"), t.$thumbnail_container ? (t.$thumbnails = t.$thumbnail_container.querySelectorAll("a"), t.$thumbnails.length <= 3 ? !1 : (t.$thumbnail_active = t.$thumbnail_container.querySelector("a.active"), void (t.$thumbnail_container.scrollLeft = t.$thumbnail_active.offsetLeft - 100))) : !1
        }

        a(e);
        var t = {}
    }
}, , , , , , , , , , , , , function (e, t, n) {
    var a = n(1), o = n(10), r = n(2);
    e.exports = function () {
        "use strict";

        function e() {
            a(function () {
                l.init(), c.init(), s.init()
            })
        }

        function t(e) {
            return document.getElementById(e)
        }

        if (window.THEME_CONFIG.theme_custom_sign) {
            var n = {}, i = {
                fm_login_id: "fm-sign-login",
                fm_reg_id: "fm-sign-register",
                fm_recover_id: "fm-sign-recover",
                fm_reset_id: "fm-sign-reset",
                process_url: ""
            };
            i = r(i, window.THEME_CONFIG.theme_custom_sign);
            var s = {
                init: function () {
                    if (n.$fm_reset = t(i.fm_reset_id), !n.$fm_reset) return !1;
                    var e = new o;
                    e.process_url = i.process_url, e.done = function (e) {
                        e && "success" === e.status && (location.href = e.redirect)
                    }, e.loading_tx = window.THEME_CONFIG.lang.M01, e.error_tx = window.THEME_CONFIG.lang.E01, e.$fm = n.$fm_reset, e.init()
                }
            }, c = {
                init: function () {
                    if (n.$fm_recover = t(i.fm_recover_id), !n.$fm_recover) return !1;
                    var e = new o;
                    e.process_url = i.process_url, e.loading_tx = window.THEME_CONFIG.lang.M01, e.error_tx = window.THEME_CONFIG.lang.E01, e.$fm = n.$fm_recover, e.init()
                }
            }, l = {
                init: function () {
                    if (n.$fm_login = t(i.fm_login_id), n.$fm_reg = t(i.fm_reg_id), n.$fm_login) {
                        var e = new o;
                        e.process_url = i.process_url, e.done = function (e) {
                            e && "success" === e.status && (location.hash = "", location.reload())
                        }, e.loading_tx = window.THEME_CONFIG.lang.M01, e.error_tx = window.THEME_CONFIG.lang.E01, e.$fm = n.$fm_login, e.init()
                    } else if (n.$fm_reg) {
                        var e = new o;
                        e.process_url = i.process_url, e.done = function (e) {
                            e && "success" === e.status && (location.hash = "", location.reload())
                        }, e.loading_tx = window.THEME_CONFIG.lang.M01, e.error_tx = window.THEME_CONFIG.lang.E01, e.$fm = n.$fm_reg, e.init()
                    }
                }
            };
            e()
        }
    }
}]);