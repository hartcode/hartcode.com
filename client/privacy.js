!(function (e) {
  function t(t) {
    for (
      var n, l, s = t[0], i = t[1], u = t[2], d = 0, f = [];
      d < s.length;
      d++
    )
      (l = s[d]), r[l] && f.push(r[l][0]), (r[l] = 0)
    for (n in i) Object.prototype.hasOwnProperty.call(i, n) && (e[n] = i[n])
    for (c && c(t); f.length; ) f.shift()()
    return o.push.apply(o, u || []), a()
  }
  function a() {
    for (var e, t = 0; t < o.length; t++) {
      for (var a = o[t], n = !0, s = 1; s < a.length; s++) {
        var i = a[s]
        0 !== r[i] && (n = !1)
      }
      n && (o.splice(t--, 1), (e = l((l.s = a[0]))))
    }
    return e
  }
  var n = {},
    r = { 8: 0 },
    o = []
  function l(t) {
    if (n[t]) return n[t].exports
    var a = (n[t] = { i: t, l: !1, exports: {} })
    return e[t].call(a.exports, a, a.exports, l), (a.l = !0), a.exports
  }
  ;(l.m = e),
    (l.c = n),
    (l.d = function (e, t, a) {
      l.o(e, t) || Object.defineProperty(e, t, { enumerable: !0, get: a })
    }),
    (l.r = function (e) {
      'undefined' != typeof Symbol &&
        Symbol.toStringTag &&
        Object.defineProperty(e, Symbol.toStringTag, { value: 'Module' }),
        Object.defineProperty(e, '__esModule', { value: !0 })
    }),
    (l.t = function (e, t) {
      if ((1 & t && (e = l(e)), 8 & t)) return e
      if (4 & t && 'object' == typeof e && e && e.__esModule) return e
      var a = Object.create(null)
      if (
        (l.r(a),
        Object.defineProperty(a, 'default', { enumerable: !0, value: e }),
        2 & t && 'string' != typeof e)
      )
        for (var n in e)
          l.d(
            a,
            n,
            function (t) {
              return e[t]
            }.bind(null, n)
          )
      return a
    }),
    (l.n = function (e) {
      var t =
        e && e.__esModule
          ? function () {
              return e.default
            }
          : function () {
              return e
            }
      return l.d(t, 'a', t), t
    }),
    (l.o = function (e, t) {
      return Object.prototype.hasOwnProperty.call(e, t)
    }),
    (l.p = '')
  var s = (window.webpackJsonp = window.webpackJsonp || []),
    i = s.push.bind(s)
  ;(s.push = t), (s = s.slice())
  for (var u = 0; u < s.length; u++) t(s[u])
  var c = i
  o.push([44, 0]), a()
})([
  ,
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n,
      r = a(0),
      o = (n = r) && n.__esModule ? n : { default: n }
    class l extends o.default.Component {
      render() {
        return o.default.createElement(
          'a',
          { href: this.props.url },
          o.default.createElement('img', {
            className: 'socialMenuItem',
            src: this.props.image
          })
        )
      }
    }
    t.default = l
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = s(a(0)),
      r = s(a(6)),
      o = s(a(8)),
      l = s(a(10))
    function s(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class i extends n.default.Component {
      render() {
        return n.default.createElement(
          'ul',
          { className: 'menu' },
          n.default.createElement(
            'li',
            null,
            n.default.createElement(r.default, {
              username: this.props.facebook.username
            })
          ),
          n.default.createElement(
            'li',
            null,
            n.default.createElement(o.default, {
              username: this.props.twitter.username
            })
          ),
          n.default.createElement(
            'li',
            null,
            n.default.createElement(l.default, {
              username: this.props.github.username,
              dark: this.props.github.dark
            })
          )
        )
      }
    }
    t.default = i
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = o(a(0)),
      r = o(a(4))
    o(a(14))
    function o(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class l extends n.default.Component {
      render() {
        return n.default.createElement(
          'div',
          { className: 'header' },
          n.default.createElement(
            'nav',
            { class: 'navbar navbar-expand-md navbar-dark bg-dark' },
            n.default.createElement('img', {
              src: r.default,
              width: '180',
              height: '180'
            }),
            n.default.createElement(
              'div',
              { className: 'company-title mr-auto' },
              n.default.createElement('h1', null, 'HartCode'),
              n.default.createElement('h2', null, 'Game Studio')
            ),
            n.default.createElement(
              'button',
              {
                class: 'navbar-toggler',
                type: 'button',
                'data-toggle': 'collapse',
                'data-target': '#navbarNav',
                'aria-controls': 'navbarNav',
                'aria-expanded': 'false',
                'aria-label': 'Toggle navigation'
              },
              n.default.createElement('span', { class: 'navbar-toggler-icon' })
            ),
            n.default.createElement(
              'div',
              { class: 'collapse navbar-collapse', id: 'navbarNav' },
              n.default.createElement(
                'ul',
                { class: 'navbar-nav ml-auto' },
                n.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  n.default.createElement(
                    'a',
                    { className: 'nav-link', href: '/products' },
                    'Products'
                  )
                ),
                n.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  n.default.createElement(
                    'a',
                    { className: 'nav-link', href: '/hire' },
                    'Hire Us'
                  )
                ),
                n.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  n.default.createElement(
                    'a',
                    { className: 'nav-link', href: '/about' },
                    'About'
                  )
                )
              )
            )
          )
        )
      }
    }
    t.default = l
  },
  function (e, t, a) {
    e.exports = a.p + '../83bac1b50602cac313ef8ceb4868ad3e.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = o(a(0)),
      r = o(a(2))
    function o(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class l extends n.default.Component {
      render() {
        return n.default.createElement(
          'div',
          { className: 'footer' },
          n.default.createElement(
            'ul',
            { className: 'menu' },
            n.default.createElement(
              'li',
              null,
              n.default.createElement('a', { href: '/' }, 'Home')
            ),
            n.default.createElement(
              'li',
              null,
              n.default.createElement('a', { href: '/careers' }, 'Careers')
            ),
            n.default.createElement(
              'li',
              null,
              n.default.createElement('a', { href: '/contact' }, 'Contact Us')
            )
          ),
          n.default.createElement(r.default, {
            facebook: { username: 'hartcodellc' },
            twitter: { username: 'hartcode' },
            github: { username: 'hartcode' }
          })
        )
      }
    }
    t.default = l
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = l(a(0)),
      r = l(a(7)),
      o = l(a(1))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class s extends n.default.Component {
      render() {
        var e = 'https://facebook.com/' + this.props.username
        return n.default.createElement(o.default, { url: e, image: r.default })
      }
    }
    t.default = s
  },
  function (e, t, a) {
    e.exports = a.p + '../46b6ac49f3ed295918c8fae5050f9276.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = l(a(0)),
      r = l(a(9)),
      o = l(a(1))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class s extends n.default.Component {
      render() {
        var e = 'https://twitter.com/' + this.props.username
        return n.default.createElement(o.default, { url: e, image: r.default })
      }
    }
    t.default = s
  },
  function (e, t, a) {
    e.exports = a.p + '../664a1f44ed01e235d4bf54d3e5bfe887.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = s(a(0)),
      r = s(a(11)),
      o = s(a(12)),
      l = s(a(1))
    function s(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class i extends n.default.Component {
      render() {
        var e = 'https://github.com/' + this.props.username,
          t = r.default
        return (
          'true' === this.props.dark && (t = o.default),
          n.default.createElement(l.default, { url: e, image: t })
        )
      }
    }
    t.default = i
  },
  function (e, t, a) {
    e.exports = a.p + '../d56df49a807a9fd06eb1667a84d3810e.png'
  },
  function (e, t, a) {
    e.exports = a.p + '../0507ea4d8b2d4c92e7e76f7df0fa8ddd.png'
  },
  function (e, t, a) {
    'use strict'
    t.analytics = function () {
      var e, t, a, n, r, o
      ;(e = window),
        (t = document),
        (a = 'script'),
        (n = 'ga'),
        (e.GoogleAnalyticsObject = n),
        (e.ga =
          e.ga ||
          function () {
            ;(e.ga.q = e.ga.q || []).push(arguments)
          }),
        (e.ga.l = 1 * new Date()),
        (r = t.createElement(a)),
        (o = t.getElementsByTagName(a)[0]),
        (r.async = 1),
        (r.src = 'https://www.google-analytics.com/analytics.js'),
        o.parentNode.insertBefore(r, o),
        ga('create', 'UA-20488226-1', 'auto'),
        ga('send', 'pageview')
    }
  },
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  function (e, t, a) {
    'use strict'
    var n,
      r = a(45),
      o = a(15),
      l = a(13)
    ;((n = l) && n.__esModule ? n : { default: n }).default.analytics()
    var s = document.getElementById('root')
    null !== s && (0, o.render)((0, r.renderRoot)(), s)
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 }),
      (t.renderRoot = function () {
        return n.default.createElement(
          'div',
          null,
          n.default.createElement(r.default, null),
          n.default.createElement(
            'div',
            { className: 'body' },
            n.default.createElement('h1', null, 'Privacy Policy'),
            n.default.createElement(
              'p',
              null,
              "HartCode values your privacy and we've developed a comprehensive Privacy Policy that explains how we collect, use, and store your information. This Privacy Policy may change at HartCode's sole discretion, without notice. Therefore, we suggest that you check this page often to stay aware of the Privacy Policy. By accessing or using the HartCode Website, and/or Service, you agree to be bound by the terms and conditions of this Privacy Policy. If you do not agree to the terms and conditions of this Privacy Policy, please stop using the HartCode Website and/or Service."
            ),
            n.default.createElement(
              'p',
              null,
              'Any terms that are used herein without a definition, have the meaning attributed to them in the End User License Agreement or Terms of Use each of which is incorporated herein hereby. The End User License Agreement may be accessed at ',
              n.default.createElement(
                'a',
                { href: '/end-user-license-agreement' },
                'https://hartcode.com/end-user-license-agreement'
              ),
              '. The Terms of Use may be accessed at ',
              n.default.createElement(
                'a',
                { href: '/terms-of-use' },
                'https://hartcode.com/terms-of-use'
              ),
              '. If, after reading this Privacy Policy, you would like more information about how we collect and use select data and information, please contact us at contact@hartcode.com or Privacy Policy, c/o Alex Hart, 9941 Flagstone Drive, Cedarburg, Wisconsin 53012.'
            ),
            n.default.createElement(
              'ol',
              null,
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Personal Information')
              ),
              n.default.createElement(
                'p',
                null,
                'Personal information is data that can be used to contact or identify you. Most of the information we collect is voluntarily submitted by you such as when setting up an Account, submitting a request, or leaving us a message.'
              ),
              n.default.createElement('p', null, 'What we collect:'),
              n.default.createElement(
                'ul',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'When you register for an account, we collect your email address, name, phone number, position, school, grades and subjects taught to extent applicable. This information helps us understand how our website is being used. Your email address will serve as your login ID and is the primary way we communicate with you such as about order status and account changes.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'When you make a purchase at the HartCode Store, we collect your billing address and cardholder data. This data will be collected by a form secured by SSL. Your purchase information will be transmitted to our credit card processor via a secure gateway (Authorize.net) to debit your credit card. All parties involved in the transaction are PCI-DSS compliant. If you elect to keep your cardholder data on file for future transactions, the data is encrypted and stored at Authorize.net for your privacy and protection.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'Except as described above, we will never share your personal information with a third party.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Anonymous Data')
              ),
              n.default.createElement(
                'p',
                null,
                'We also automatically collect anonymous data that is not associated with any specific account.'
              ),
              n.default.createElement('p', null, 'What we collect:'),
              n.default.createElement(
                'ul',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'When you access the site, we record the URL, timestamp, and IP address, or other device address or identity, in our server logs for security purposes. This data is also transmitted to Google Analytics to help us improve the customer experience.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'When you access the site, we also record your operating system version, browser version, screen resolution, Java version, and Flash Player version. This data is not kept on our servers, but only stored in aggregated form in Google Analytics.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'Except as described above, we will never share your anonymous data with a third party.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement(
                  'h3',
                  null,
                  'Use & Access to Personal Information & Anonymous Data'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'We use personal information and anonymous data to operate, update our Website and provide the Services and to customize your experience with the Services and our Website. We also use such information and data for business purposes such as to determine the number of visitors to different sections of our Website, to ensure the Website is working properly, and to help us make the Website more useful. We also use this information to see where leads are generated from in an attempt to better optimize our ongoing internet marketing efforts.'
              ),
              n.default.createElement(
                'p',
                null,
                'We may use personal information to provide you marketing materials and other information about us and our products and services that may be of interest to you. You may opt out of some of these communications through the My Account page or through links in the communications.'
              ),
              n.default.createElement(
                'p',
                null,
                'Certain third-party service providers may also have access to your personal information and anonymous data, much of the time incidentally, when updates and/or maintenance is performed by such third-parties service providers. Before we allow a third-party service provider to do any work, we try ensure that they are reputable and reliable in addition to limiting the extent of their interaction with personal information and anonymous data.'
              ),
              n.default.createElement(
                'p',
                null,
                'We may also disclose personal information and anonymous data if required to do so by law or in response to judicial or government issued orders, cooperate with third parties or legal authorities in the investigation of any suspected or alleged crime or civil wrongdoing or to take precautions and protect ourselves from liability and/or defend ourselves from third party claims and allegations. We may also disclose personal information and anonymous data to protect or ensure the security or integrity of the Service and our website.'
              ),
              n.default.createElement(
                'p',
                null,
                'To the extent that HartCode includes affiliated entities such as parent or subsidiary companies, we may share personal information and anonymous data with the affiliated entities. Similarly, if HartCode is acquired or merged with a third party, we may share the personal information and anonymous data with the acquirer or merged entity. However, such sharing of personal information and anonymous data will always be done in accordance with the terms of these Privacy Policies.'
              ),
              n.default.createElement(
                'p',
                null,
                'Please note that we are not responsible for any information you provide, voluntarily or otherwise to any third party websites linked to by our Website.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Cookies')
              ),
              n.default.createElement(
                'p',
                null,
                'HartCode uses cookies to remember your login, preferences, and shopping cart. You may choose to disable cookies through your browser option, however, if you do, you will not be able to access certain features such as access to your purchases.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Safeguards')
              ),
              n.default.createElement(
                'p',
                null,
                "Just because we aim to protect your privacy doesn't mean that hackers and thieves have the same idea. Recent events have highlighted how much consumer data is stolen on a regular basis and used for identity theft. Our goal is to safeguard your data from thieves, and to provide full disclosure in case of a breach."
              ),
              n.default.createElement('p', null, 'Examples:'),
              n.default.createElement(
                'ul',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'We regularly patch our servers against the latest vulnerabilities.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'We enforce the use of strong passwords at the operating system and web-site account levels.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'The store is built on top of secure, open-source web frameworks.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'The website is always operating in SSL mode, whether you are logged in or not.'
                )
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement(
                  'h3',
                  null,
                  'Access to Personal Information'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'You can update your contact information and communication preferences from the My Account page. You can also request a copy of all of the personal information we have for your account or to delete an account, including personal information, by sending a written request to contact@hartcode.com. If you request a copy of your personal information, we will send a copy of the information to the email address listed on the account, not necessarily the email address from which the request was sent to protect such personal information. If you are requesting to delete an account, we remove all of the personal information we can. However, in some circumstances, we may not be able to delete all the personal information, for example for accounting or legal reasons or in cached or archived pages. We may also retain any aggregate data that was based upon your personal information, but not in any way that would identify you.'
              ),
              n.default.createElement(
                'p',
                null,
                'California residents can ask us for a disclosure of certain categories of personal information that have been disclosed to third parties as well as the contact information for such third parties under California Civil Code Sections 1798.83-1798.81. If you would like a copy of such information, please submit a written request to contact@hartcode.com.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'User Content')
              ),
              n.default.createElement(
                'p',
                null,
                'You may be able to post user-generated content, such as comments, photos, presentations, articles, profiles, messages, notes, text, information, music, and videos (“User Content”) in the Game, Service or on the Website. By posting such content you are voluntarily making such content accessible to other users as well as HartCode as further described in the End User License Agreement.'
              )
            )
          ),
          n.default.createElement(o.default, null)
        )
      })
    var n = l(a(0)),
      r = l(a(3)),
      o = l(a(5))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
  }
])
