!(function (e) {
  function t(t) {
    for (
      var n, i, l = t[0], s = t[1], u = t[2], d = 0, h = [];
      d < l.length;
      d++
    )
      (i = l[d]), o[i] && h.push(o[i][0]), (o[i] = 0)
    for (n in s) Object.prototype.hasOwnProperty.call(s, n) && (e[n] = s[n])
    for (c && c(t); h.length; ) h.shift()()
    return r.push.apply(r, u || []), a()
  }
  function a() {
    for (var e, t = 0; t < r.length; t++) {
      for (var a = r[t], n = !0, l = 1; l < a.length; l++) {
        var s = a[l]
        0 !== o[s] && (n = !1)
      }
      n && (r.splice(t--, 1), (e = i((i.s = a[0]))))
    }
    return e
  }
  var n = {},
    o = { 4: 0 },
    r = []
  function i(t) {
    if (n[t]) return n[t].exports
    var a = (n[t] = { i: t, l: !1, exports: {} })
    return e[t].call(a.exports, a, a.exports, i), (a.l = !0), a.exports
  }
  ;(i.m = e),
    (i.c = n),
    (i.d = function (e, t, a) {
      i.o(e, t) || Object.defineProperty(e, t, { enumerable: !0, get: a })
    }),
    (i.r = function (e) {
      'undefined' != typeof Symbol &&
        Symbol.toStringTag &&
        Object.defineProperty(e, Symbol.toStringTag, { value: 'Module' }),
        Object.defineProperty(e, '__esModule', { value: !0 })
    }),
    (i.t = function (e, t) {
      if ((1 & t && (e = i(e)), 8 & t)) return e
      if (4 & t && 'object' == typeof e && e && e.__esModule) return e
      var a = Object.create(null)
      if (
        (i.r(a),
        Object.defineProperty(a, 'default', { enumerable: !0, value: e }),
        2 & t && 'string' != typeof e)
      )
        for (var n in e)
          i.d(
            a,
            n,
            function (t) {
              return e[t]
            }.bind(null, n)
          )
      return a
    }),
    (i.n = function (e) {
      var t =
        e && e.__esModule
          ? function () {
              return e.default
            }
          : function () {
              return e
            }
      return i.d(t, 'a', t), t
    }),
    (i.o = function (e, t) {
      return Object.prototype.hasOwnProperty.call(e, t)
    }),
    (i.p = '')
  var l = (window.webpackJsonp = window.webpackJsonp || []),
    s = l.push.bind(l)
  ;(l.push = t), (l = l.slice())
  for (var u = 0; u < l.length; u++) t(l[u])
  var c = s
  r.push([48, 0]), a()
})([
  ,
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n,
      o = a(0),
      r = (n = o) && n.__esModule ? n : { default: n }
    class i extends r.default.Component {
      render() {
        return r.default.createElement(
          'a',
          { href: this.props.url },
          r.default.createElement('img', {
            className: 'socialMenuItem',
            src: this.props.image
          })
        )
      }
    }
    t.default = i
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = l(a(0)),
      o = l(a(6)),
      r = l(a(8)),
      i = l(a(10))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class s extends n.default.Component {
      render() {
        return n.default.createElement(
          'ul',
          { className: 'menu' },
          n.default.createElement(
            'li',
            null,
            n.default.createElement(o.default, {
              username: this.props.facebook.username
            })
          ),
          n.default.createElement(
            'li',
            null,
            n.default.createElement(r.default, {
              username: this.props.twitter.username
            })
          ),
          n.default.createElement(
            'li',
            null,
            n.default.createElement(i.default, {
              username: this.props.github.username,
              dark: this.props.github.dark
            })
          )
        )
      }
    }
    t.default = s
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = r(a(0)),
      o = r(a(4))
    r(a(14))
    function r(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class i extends n.default.Component {
      render() {
        return n.default.createElement(
          'div',
          { className: 'header' },
          n.default.createElement(
            'nav',
            { class: 'navbar navbar-expand-md navbar-dark bg-dark' },
            n.default.createElement('img', {
              src: o.default,
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
    t.default = i
  },
  function (e, t, a) {
    e.exports = a.p + '../83bac1b50602cac313ef8ceb4868ad3e.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = r(a(0)),
      o = r(a(2))
    function r(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class i extends n.default.Component {
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
          n.default.createElement(o.default, {
            facebook: { username: 'hartcodellc' },
            twitter: { username: 'hartcode' },
            github: { username: 'hartcode' }
          })
        )
      }
    }
    t.default = i
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = i(a(0)),
      o = i(a(7)),
      r = i(a(1))
    function i(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class l extends n.default.Component {
      render() {
        var e = 'https://facebook.com/' + this.props.username
        return n.default.createElement(r.default, { url: e, image: o.default })
      }
    }
    t.default = l
  },
  function (e, t, a) {
    e.exports = a.p + '../46b6ac49f3ed295918c8fae5050f9276.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = i(a(0)),
      o = i(a(9)),
      r = i(a(1))
    function i(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class l extends n.default.Component {
      render() {
        var e = 'https://twitter.com/' + this.props.username
        return n.default.createElement(r.default, { url: e, image: o.default })
      }
    }
    t.default = l
  },
  function (e, t, a) {
    e.exports = a.p + '../664a1f44ed01e235d4bf54d3e5bfe887.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = l(a(0)),
      o = l(a(11)),
      r = l(a(12)),
      i = l(a(1))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class s extends n.default.Component {
      render() {
        var e = 'https://github.com/' + this.props.username,
          t = o.default
        return (
          'true' === this.props.dark && (t = r.default),
          n.default.createElement(i.default, { url: e, image: t })
        )
      }
    }
    t.default = s
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
      var e, t, a, n, o, r
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
        (o = t.createElement(a)),
        (r = t.getElementsByTagName(a)[0]),
        (o.async = 1),
        (o.src = 'https://www.google-analytics.com/analytics.js'),
        r.parentNode.insertBefore(o, r),
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
  ,
  ,
  ,
  ,
  function (e, t, a) {
    'use strict'
    var n,
      o = a(49),
      r = a(15),
      i = a(13)
    ;((n = i) && n.__esModule ? n : { default: n }).default.analytics()
    var l = document.getElementById('root')
    null !== l && (0, r.render)((0, o.renderRoot)(), l)
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 }),
      (t.renderRoot = function () {
        return n.default.createElement(
          'div',
          null,
          n.default.createElement(o.default, null),
          n.default.createElement(
            'div',
            { className: 'body' },
            n.default.createElement('h1', null, 'End User License Agreement'),
            n.default.createElement('h2', null, 'HartCode LLC'),
            n.default.createElement('h2', null, 'End User License Agreement'),
            n.default.createElement(
              'p',
              null,
              'BEFORE YOU CLICK ON THE "Agree" BUTTON AT THE END OF THIS DOCUMENT, CAREFULLY READ THE TERMS AND CONDITIONS OF THIS AGREEMENT. BY CLICKING ON THE "Agree" BUTTON, YOU ARE CONSENTING TO BE BOUND BY AND ARE BECOMING A PARTY TO THIS AGREEMENT. IF YOU DO NOT AGREE TO THE TERMS AND CONDITIONS OF THIS AGREEMENT, PLEASE STOP USING THE HARTCODE WEBSITE, Game AND/OR SERVICE.'
            ),
            n.default.createElement('p', null, '* * * * *'),
            n.default.createElement(
              'ol',
              null,
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'General Terms.')
              ),
              n.default.createElement(
                'p',
                null,
                'This is an agreement (“Agreement”) between you and HartCode LLC, (“HartCode”) that governs your use of the HartCode Website (the website at “hartcode.com”), your purchase of Licenses, and your use of accounts and Game software (“Software”) through the HartCode Website. The Terms of Use for the HartCode Website, available at ',
                n.default.createElement(
                  'a',
                  { href: '/terms-of-use' },
                  'https://hartcode.com/terms-of-use'
                ),
                ' is fully incorporated into this Agreement by reference.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Description of Service.')
              ),
              n.default.createElement(
                'p',
                null,
                'HartCode is proud to provide you with license-based online access to certain of its Games through Game software downloaded, streamed or otherwise provided to your computer via the Internet (the “Service”). HartCode will make select versions of certain of its games available for use through purchase of a License. Access to Games through the Service is license-based. Your License provides access only to one version of the game selected (“Game”). Therefore, there may be multiple Games for a given game. In order to access a new version of the game, you must purchase another License for that version. You may access the Game using your Account and either purchasing a License or using a Sub-License Code provided by an owner of a License. If you purchase access to one of our Games, you will receive a License to use the Game (“License”). To use your License(s) you will log into your Account and enter the access code (the “License Code”) associated with the License into the Game entry interface available on the HartCode Website. If you are using a Sub-License Code, you will log into your Account and enter the Sub-License Code into the Game entry interface available on the HartCode Website.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Applications.')
              ),
              n.default.createElement(
                'p',
                null,
                'Select Games may be available for download through the HartCode Website and/or third-party stores (“Applications”). You may download an Application for personal, non-commercial use only. By downloading an Application, HartCode is providing you a limited, non-exclusive, non-transferable, non-sublicensable license to use the Application with or apart from the Service. By downloading an Application, you agree to be bound by this Agreement, including the Terms of Use and Privacy Policy incorporated herein, in addition to any third-party agreements to the extent such Application was downloaded from a third-party store.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Account Eligibility.')
              ),
              n.default.createElement(
                'p',
                null,
                'To purchase Licenses to or use the Games offered under this Agreement, you must register for a user account (an “Account”) on the HartCode Website. Accounts are available only to adult individuals 18 years of age or older. If you are less than 18 years of age and wish to use HartCode’s Licenses, your parent or legal guardian or an educator must complete the registration process, open an Account in their name, without providing personal information of anyone less than 18 years of age, accept full responsibility for all obligations under this Agreement and create a general sub-account for use by a person under the age of 18.'
              ),
              n.default.createElement(
                'ol',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'By accepting the terms of this Agreement, you represent that you are an adult 18 years of age or older.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'If you are the Account Holder who purchased a License (“Purchasing Account Holder”), you may permit other individuals to access and use the Game by providing a Sub-License Code created by you, however, you agree that you are liable for all activities conducted in connection with the Sub-License Code, that you will only permit a minor child or children to use the Sub-License Code under your supervision and that you will not provide personal information of anyone less than 18 years of age unless that person is your child or of which you are legal guardian.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'If you are accepting this Agreement on behalf of an institution, company or other legal entity you represent and warrant that you have the authority to enter into this Agreement on that institution, company or other legal entity’s behalf and you intend to bind institution, company or other legal entity hereto. The terms “you, “your” and similar variants in this Agreement include both you and the institution, company or other legal entity.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'HartCode may suspend, terminate, modify, or delete the Account at any time for any reason, with or without notice to you. Most Account suspensions, terminations, and/or deletions are the result of violations of this Agreement or are a result of an abandoned Account.'
                )
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement(
                  'h3',
                  null,
                  'Financial Transactions On the Account.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'You acknowledge and agree that HartCode is authorized, but not required, to act on payment instructions received from anyone using the Account. You authorize HartCode to (a) initiate debits or charges against your financial account or credit card periodically for the amount then due for purchases made; and (b) initiate any other debits or credits authorized by you or anyone using the Account registered to you. All payments must be made in U.S. dollars from a U.S. bank or via alternative payment methods made available by HartCode. You acknowledge that transactions may be facilitated by a third party payment processor (the “Processor”), and agree that HartCode may share your information, including information about your financial accounts, with the Processor, for this purpose. All amounts paid are non-refundable, except where and to the extent required by law.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement(
                  'h3',
                  null,
                  'Member Account, Password and Security.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'If you create an Account on the HartCode Website, you will receive a password and account designation upon completing the registration process. You are responsible for maintaining the confidentiality of the password and Account, and are fully responsible for all activities that occur under your password, and Account. When creating an account you agree to: (a) provide true, accurate, current and complete information about yourself as prompted by the registration form (your “Registration Data”); (b) maintain and promptly update the Registration Data to keep it true, accurate, current and complete; (c) immediately notify HartCode of any unauthorized use of your password, Account, License Code or Sub-License Code or any other breach of security; and (d) ensure that you exit from your Account at the end of each session. HartCode has the right to suspend or terminate your Account and refuse your use of the Service for any reason, including for violations of this or any other agreement with HartCode.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Licenses.')
              ),
              n.default.createElement(
                'p',
                null,
                'Licenses are available for a varying number of Game as offered on the HartCode Website. Each License is a non-exclusive, non-transferable (except as expressly provided through use of Sub-License Codes), non-assignable, revocable limited license subject to the limitations of this Agreement and use of the Service for your own non-commercial entertainment purposes. If you believe that your License Code has been lost, stolen, or is being abused, please contact HartCode at contact@hartcode.com and a new License Code may be issued if appropriate as determined by the sole discretion of HartCode. Fees for Licenses will be charged in accordance to the fees and any additional terms published on the HartCode Website. The License begins when it is purchased and it will continue until the Game is retired or the Account or License is terminated. Games may be retired at any time for any reason, with or without notice to you, in HartCode’s sole discretion. Most Game retirements will commence when use of the Game wanes and/or a new version of the underlying game is offered such that it is no longer beneficial to continue to support the older Game. Upon retirement of the Game for your License, you will no longer be able to access the game. You acknowledge and agree that you are not entitled to any refund for any amounts paid or pre-paid in connection with the Account upon retirement of a Game.'
              ),
              n.default.createElement(
                'p',
                null,
                'You understand and agree that you have no interest, monetary or otherwise, in any feature or content contained in the Game, including without limitation, the Account registered to you, in-game items or currency or anything of value in the real world without HartCode’s express written consent.'
              ),
              n.default.createElement('p', null, 'Additionally, you may not:'),
              n.default.createElement(
                'ol',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'Sublicense, lease, loan, or otherwise transfer your Account, Licenses, or License Codes;'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Modify, adapt, reverse engineer or decompile the Software, or otherwise attempt to derive source code from any of HartCode’s products;'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Create any copies or derivative works regarding the Software or the Service;'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Use maillist, listserv, an auto-repsonder or spam on the Service or any processes that run or are activated while you are not logged in to your Account, or that otherwise interfere with the proper working of the Service;'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Crawl, scrape, or spider any page or portion of the Service of the HartCode Webiste; or'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Otherwise use the Software or the Service except as expressly provided in this Agreement. You should keep your License Codes, passwords, and other Account information in a safe place.',
                  n.default.createElement('br', null),
                  'Title to the Software, and all rights with respect to the Software and the Service not expressly addressed in this Agreement, including without limitation, all rights of reproduction, modification, distribution, display, disassembly and decompilation and all copyright, patent, trademark, trade secret and other proprietary rights and interests are reserved to HartCode.'
                )
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Sub-License Codes.')
              ),
              n.default.createElement(
                'p',
                null,
                'Each License is associated with a License Code that is used to access the License on the HartCode Website. Each License is authorized for a maximum number of concurrent non-purchasing users, e.g. students, (“Users”), meaning that those Users can all access the Game at the same time. To allow Users to use the Game, the Purchasing Account Holder may create Sub-License Codes and provide them to the Users. Each Sub-License Code will only be effective for a term. The current term for any Sub-License Code is two (2) months, after which the Sub-License Code will expire. HartCode reserves the right to adjust the term for any Sub-License Code at any time for any reason, with or without notice to you, in its sole discretion. At any time, including at expiration of a Sub-License Code, the Purchasing Account Holder may create new or additional Sub-License Codes, e.g. to provide access to different Users during the course of the License, but in no event may the number of active Sub-License Codes exceed the maximum number of Users authorized for a License. Exceeding the maximum number of Users authorized for a License may result in termination of the associated License or suspension or disabling of your Account. If you believe that one of your Sub-License Codes has been lost, stolen, or is being abused, please contact HartCode at contact@hartcode.com.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Intellectual Property.')
              ),
              n.default.createElement(
                'p',
                null,
                'The content in the Game, except User Content (as defined below) to the extent any exists, including without limitation, the trademarks, copyrights, text, software, graphics, photos, music, videos, and the like (“Content”), is owned by or licensed to HartCode and is subject to trademark, copyright and other intellectual property laws of the United States and foreign countries. Content in the Game is provided for your personal use only and may not be used, copied, reproduced, distributed, transmitted, broadcast, displayed, sold, licensed, or otherwise exploited for any other purposes whatsoever without the prior written consent of HartCode. HartCode reserves all rights not expressly granted in and to the Game and the Content.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'User Content.')
              ),
              n.default.createElement(
                'p',
                null,
                'You may be able to post user-generated content, such as comments, photos, presentations, articles, profiles (including your name, image, and likeness), messages, notes, text, information, music, and videos (“User Content”) in the Game, Website and/or Service. You will remain the owner of the User Content. By posting User Content, you grant HartCode an irrevocable, perpetual, non-exclusive, transferable, sub-licensable, fully paid, worldwide license (with the right to sublicense) to use, copy, publicly perform, publicly display, reformat, edit, translate, excerpt (in whole or in part) and distribute such User Content for any purpose, commercial, advertising, or otherwise, on or in connection with HartCode, the Game or the promotion thereof, to prepare derivative works of, or incorporate into other works, such User Content, and to grant and authorize sublicenses of the foregoing. For example and without limiting the foregoing, by posting comments to any portion of the Game, you grant HartCode the right to use, copy, edit, highlight, feature, distribute, and display those comments or any portion thereof in the Game and in promotions thereof in any manner and for any purpose. By posting User Content, you represent and warrant that (i) you have the right to post the User Content, (ii) that no third party rights, laws or regulations, e.g. COPPA and FERPA, will be violated by such posting, (iii) that you have the right to grant HartCode the rights granted herein, (iv) that no User Content contains any personal information regarding anyone under the age of 18, (v) the User Content is not harmful, fraudulent, threatening, abusive, harassing, defamatory, vulgar, obscene, libelous, or otherwise objectionable or offensive, and (vi) the User Content does not make the security of your Account, Game, Website and/or Service vulnerable in any way . You acknowledge that HartCode and its designees shall have the right (but not the obligation) in their sole discretion to refuse or remove any User Content or material that is available through the Game. You also hereby grant each Account Holder or User a non-exclusive, fully paid, worldwide license to use, copy, publicly perform, publicly display, reformat, edit, translate, excerpt (in whole or in part) any User Content submitted by you during use of the Website, Game or Service.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Privacy.')
              ),
              n.default.createElement(
                'p',
                null,
                'Our Privacy Policy governs the collection, use and disclosure of all Personal Data (personally identifiable information about you, such as your full name, birth date, e-mail address or mailing address, phone number and any other information that can be used to identify or contact you). Our Privacy Policy is hereby incorporated herein. For more information, see our full privacy policy at ',
                n.default.createElement(
                  'a',
                  { href: '/privacy' },
                  'https://hartcode.com/privacy'
                ),
                '.'
              ),
              n.default.createElement(
                'p',
                null,
                'An Account Holder, e.g. a teacher, may provide information to HartCode, such as student directory data and performance statistics, which may be interpreted as an educational record (“Directory Information”) under the Family Educational Rights and Privacy Act (“FERPA”). FERPA permits disclosure of Directory Information, but requires schools to tell parents and eligible students about Directory Information disclosed and allow parents and eligible students a reasonable amount of time to request that the school not disclose Directory Information. If you are an Account Holder and provide HartCode such Directory Information through the Website, Game or Service, you hereby by represent and warrant that you have complied with FERPA including informing parents and eligible students about the disclosure of Directory Information and allow parents and eligible students a reasonable amount of time to request the non-disclosure of such Directory Information.'
              ),
              n.default.createElement(
                'p',
                null,
                'You agree that HartCode and/or the Purchasing Account Holder that provided you a Sub-License Code may send you messages, alerts, and other communications through the Website, Game or Service, including through email, text message and other similar means in accordance with the preferences you set, and you agree to accept such messages, and pay any applicable network access, data usage, or similar fees.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement(
                  'h3',
                  null,
                  'Third Party Intellectual Property.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'HartCode respects the intellectual property rights of others. We will respond promptly to remove material that infringes another person’s copyright or other intellectual property right. When reporting infringing material to HartCode (“DMCA Notice”) please provide:'
              ),
              n.default.createElement(
                'ol',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'A physical or electronic signature of a person authorized to act on behalf of the owner of an exclusive right that is allegedly infringed.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Identification of the copyrighted work claimed to have been infringed, or, if multiple copyrighted works at a single online site are covered by a single notification, a representative list of such works at that site.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Identification of the material that is claimed to be infringing or to be the subject of infringing activity and that is to be removed or access to which is to be disabled, and information reasonably sufficient to permit HartCode to locate the material.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Information reasonably sufficient to permit HartCode to contact the complaining party, such as an address, telephone number, and, if available, an electronic mail address at which the complaining party may be contacted.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'A statement that the complaining party has a good faith belief that use of the material in the manner complained of is not authorized by the copyright owner, its agent, or the law.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'A statement that the information in the notification is accurate, and under penalty of perjury, that the complaining party is authorized to act on behalf of the owner of an exclusive right that is allegedly infringed.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'Upon receiving a complete DMCA Notice, HartCode will'
              ),
              n.default.createElement(
                'ol',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'take reasonable steps promptly to notify the Account Holder that HartCode has removed or disabled access to the allegedly infringing material;'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'upon receipt of a counter notification described below, promptly provide the person who provided the notification with a copy of the counter notification, and inform that person that HartCode will replace the removed material or cease disabling access to it in 10 business days; and'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'replace the removed material and cease disabling access to it not less than 10, nor more than 14, business days following receipt of the counter notice, unless HartCode’s designated agent (identified below) first receives notice from the person who submitted the notification that such person has filed an action seeking a court order to restrain the Account Holder from engaging in infringing activity relating to the material on HartCode Website or through the Service.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'A counter notification must include:'
              ),
              n.default.createElement(
                'ol',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'A physical or electronic signature of the Account Holder.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Identification of the material that has been removed or to which access has been disabled and the location at which the material appeared before it was removed or access to it was disabled.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'A statement under penalty of perjury that the Account Holder has a good faith belief that the material was removed or disabled as a result of mistake or misidentification of the material to be removed or disabled.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'The Account Holder’s name, address, and telephone number, and a statement that the Account Holder consents to the jurisdiction of Federal District Court for the judicial district in which the address is located, or if the Account Holder’s address is outside of the United States, for any judicial district in which HartCode may be found, and that the Account Holder will accept service of process from the person who provided notification or an agent of such person.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'Pursuant to the Digital Millennium Copyright Act (17 U.S.C. §512(c)(2)), our designated agent to receive notices of claimed infringement is:'
              ),
              n.default.createElement(
                'p',
                null,
                'DMCA Notice',
                n.default.createElement('br', null),
                'c/o Alex Hart',
                n.default.createElement('br', null),
                '9941 Flagstone Dr',
                n.default.createElement('br', null),
                'Cedarburg, WI 53012',
                n.default.createElement('br', null),
                'contact@hartcode.com'
              ),
              n.default.createElement(
                'p',
                null,
                'We reserve the right to remove any infringing material that we believe in good faith to be copyrighted material that is used without authorization by any Account Holder or other user of the HartCode Website, Game and/or Services. We also reserve the right to suspend or delete the Account of any repeat offender.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Amendments to Agreement.')
              ),
              n.default.createElement(
                'p',
                null,
                'HartCode may update this Agreement at its sole discretion, and you may be asked to review and agree to a revised version. If you do not agree to the revised version of this Agreement, you will not be permitted to continue use of your Licenses. If at any time you become no longer able to comply with the terms of the current version of this Agreement, you must terminate this Agreement and immediately stop using any Licenses, License Codes and Sub-License Codes. You acknowledge and agree that you are not entitled to any refund for any amounts paid or pre-paid in connection with the Account prior to termination of this Agreement.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Patches and Updates.')
              ),
              n.default.createElement(
                'p',
                null,
                'HartCode may apply patches, updates and modifications to its Games at any time (each an “Update”), and gameplay may change after the application of an Update. HartCode may change, modify, suspend, or discontinue any aspect of any Game at any time. HartCode may also impose limits on certain features or restrict your access to parts or all of a Game without notice or liability. HartCode makes no representation that a Game will work on a particular web browser, version of a web browser or device. You are responsible for having necessary Internet connections, equipment, software (including a web browser) and services for you to effectively access the HartCode Website and use of the Game. HartCode will endeavor to make the HartCode Website and Game accessible on the most common web browsers and the current and penultimate version of such web browsers and some common devices, but make no representations or warranties on the same.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Termination.')
              ),
              n.default.createElement(
                'p',
                null,
                'This Agreement is effective until terminated. You may terminate this Agreement by deactivating your Account. In the event that you terminate or breach this Agreement, you will forfeit your right to any and all purchases of Licenses and other payments made in connection with Games or the Game Server and Accounts, Licenses, License Codes and Sub-License Codes will terminate. HartCode may terminate this Agreement with or without notice by deactivating the Account. By way of example only, HartCode may deactivate and/or terminate abandoned Accounts or Accounts which appear to be abandoned such as due to non-use for period of time. A termination of this Agreement will also act to terminate your Account, License, License Code(s) and Sub-License Code(s). You acknowledge and agree that you are not entitled to any refund for any amounts paid or pre-paid in connection with the Account prior to termination of this Agreement.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Indemnification.')
              ),
              n.default.createElement(
                'p',
                null,
                'You agree to indemnify and hold harmless HartCode, and its subsidiaries, affiliates, officers, agents, and employees, from any claim or demand by any third party arising out of your use of the Services, including but not limited to, the use of any Account, License, License Code or Sub-License Code, your use of the HartCode Website, Game, and Service, your violation of this Agreement, HartCode’s Website Terms of Use, or your violation of any rights of another person or entity.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'DISCLAIMER.')
              ),
              n.default.createElement(
                'p',
                null,
                'THIS SERVICE, INCLUDING ANY CONTENT OR INFORMATION CONTAINED WITHIN OR PROVIDED THROUGH IT, IS PROVIDED “AS IS” WITH NO REPRESENTATIONS OR WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT. YOU ASSUME TOTAL RESPONSIBILITY AND RISK FOR YOUR USE OF THIS SERVICE, THE HARTCODE WEBSITE, Game AND THE INFORMATION RECEIVED THROUGH IT. FURTHER, HARTCODE MAKES NO REPRESENTATIONS WHATSOEVER ABOUT OTHER WEBSITES WHICH YOU MAY ACCESS THROUGH ITS HARTCODE WEBSITE or the content, SERVICES OR PRODUCTS contained therein or obtained there through. HARTCODE FURTHER DOES NOT WARRANT THE QUALITY, VALIDITY, ACCURACY OR COMPLETENESS OF THE MATERIALS OR THAT THE FUNCTIONS CONTAINED ON THE HARTCODE WEBSITE, SERVICE AND/OR Game WILL BE UNINTERRUPTED OR ERROR-FREE, OR THAT DEFECTS OR INACCURACIES WILL BE CORRECTED. HARTCODE MAY MAKE CHANGES TO THE MATERIALS OR SERVICES, OR TO THE PRODUCTS, SERVICES, SPECIFICATIONS OR PRICES DESCRIBED IN THEM, AT ANY TIME WITHOUT NOTICE. THE MATERIALS MAY BE OUT OF DATE, AND HARTCODE MAKES NO COMMITMENT TO UPDATE THE MATERIALS AT ITS WEBSITE, SERVICE AND/OR Game OR TO MAKE ANY NOTIFICATION OF CHANGES. INFORMATION PUBLISHED AT THE HARTCODE WEBSITE OR IN CONNECTION WITH THE SERVICE or Game MAY REFER TO PRODUCTS, PROGRAMS OR SERVICES THAT ARE NOT AVAILABLE. YOU HEREBY RELEASE HARTCODE from any and all claims, demands and damages, known or unknown, suspected or unsuspected, disclosed or undisclosed, arising out of or in any way related to a dispute between you and another Account Holder. California residents hereby shall and do waive California Civil Code 1542, which provides “A general release does not extend to claims which the creditor does not know or suspect to exist in his or her favor at the time of executing the release, which if known by him or her must have materially affected his or her settlement with the debtor.”'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Limitation of Liability.')
              ),
              n.default.createElement(
                'p',
                null,
                'HARTCODE AND ITS MEMBERS, DIRECTORS, OFFICERS, EMPLOYEES AND AGENTS AND ITS AFFILIATES ARE NEITHER RESPONSIBLE NOR LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, CONSEQUENTIAL, SPECIAL, EXEMPLARY, PUNITIVE OR OTHER DAMAGES ARISING OUT OF OR RELATING IN ANY WAY TO THE SERVICE, ITS HARTCODE WEBSITE, SERVICE AND/OR Game OR ANY INFORMATION RECEIVED FROM THE WEBSITE, INCLUDING THE CONTENT OR ANY INFORMATION CONTAINED WITHIN OR THROUGH THE WEBSITE, SERVICE AND/OR Game. YOUR SOLE REMEDY FOR DISSATISFACTION WITH THE SERVICE AND THE HARTCODE WEBSITE IS TO TERMINATE YOUR ACCOUNT AND/OR STOP USING THE WEBSITE, THE SERVICE, Game, AND THE INFORMATION OBTAINED THEREIN.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Miscellaneous.')
              ),
              n.default.createElement(
                'p',
                null,
                'This Agreement and the relationship between you and HartCode shall be governed by the laws of the State of Wisconsin. You hereby consent to the exclusive jurisdiction and forum of the federal and state courts located in the State of Wisconsin for all purposes in connection with any action or proceeding which arises out of or relates to your use of the Game, Service, the Website, this Agreement, as well as any Account, License, License Code, Sub-License Code, Processor, Registration, Software, or Update. HartCode’s failure to enforce any right or provision of this Agreement does not constitute a waiver of that right or provision.'
              )
            )
          ),
          n.default.createElement(r.default, null)
        )
      })
    var n = i(a(0)),
      o = i(a(3)),
      r = i(a(5))
    function i(e) {
      return e && e.__esModule ? e : { default: e }
    }
  }
])
